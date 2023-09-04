package br.com.estudos.oauth2.utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.math.BigDecimal;
import java.util.Date;

import br.com.estudos.oauth2.annotation.ExcelHeaderColumn;

public class ExportToExcelFile{

     public static <T> byte[]  writeToExcel(String fileName, List<T> data){
          try { 
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             OutputStream fos = null;
	          Workbook workbook = new XSSFWorkbook();             
		       Sheet sheet = workbook.createSheet();

             int rowCount = 0 ;
             int columnCount = 0;             
		       Row row = sheet.createRow(rowCount++);
             List<String> nameFields        = getFieldNamesForHeaderOrContent(data.get(0).getClass(),"H");
             List<String> nameFieldsContent = getFieldNamesForHeaderOrContent(data.get(0).getClass(),"C");
             for (String nameField : nameFields) {
			       Cell cell = row.createCell(columnCount++);
			       cell.setCellValue(nameField);
             }

             // Conteudo
             Class<? extends Object> classz = data.get(0).getClass();  
             for(T t: data){
               row = sheet.createRow(rowCount++);
               columnCount = 0;
               for(String nameField : nameFieldsContent){                  
					   Cell cell = row.createCell(columnCount);
                  Method method = null;
					   try {
						   method = classz.getMethod("get" + capitalizeFirstCaracter(nameField));
					   } catch (NoSuchMethodException nme) {
					   	method = classz.getMethod("get" + nameField);
					   }
                  Object value = method.invoke(t, (Object[]) null);
                  if(value != null){
                     if(value instanceof String){
                        cell.setCellValue((String) value);
                     }else if(value instanceof Integer){
                        cell.setCellValue((Integer) value);
                     }else if(value instanceof Double){
                        cell.setCellValue((Double) value);
                     }else if(value instanceof Date){
                        cell.setCellValue((Date) value);
                     }else if (value instanceof BigDecimal) {
                        BigDecimal bigDecimal = (BigDecimal) value;
                        double doubleValue    = bigDecimal.doubleValue();
							   cell.setCellValue(doubleValue);
						   }
                     
                  }
                  columnCount++;
               }

             }
             

             workbook.write(outputStream);
             byte[] excelBytes = outputStream.toByteArray();

             return excelBytes;

          }catch(Exception ex){
             ex.printStackTrace();
             return new byte[0]; 
          }
     
          
     }

     // Pegar os nomes dos campos na classe
     private static List<String> getFieldNamesForHeaderOrContent(Class<?> clazz, String indicator) throws Exception {
        List<String> fieldNames = new ArrayList<String>();
        Field[] fields = clazz.getDeclaredFields();
        IntStream.range(0,fields.length).forEach(index -> {            
            if(fields[index].isAnnotationPresent(ExcelHeaderColumn.class) && indicator == "H"){
               fieldNames.add(fields[index].getAnnotation(ExcelHeaderColumn.class).value());
            }else{
               fieldNames.add(fields[index].getName());
            }         
        });
        return fieldNames;
     }

     // Deixar a primeira letra do nome do campo em maiusculo para ser pego no metodo get do mesmo campo.
     private static String capitalizeFirstCaracter(String s){
        if (s.length() == 0){
           return s;
        }
        return s.substring(0,1).toUpperCase() + s.substring(1);

     }

 
}