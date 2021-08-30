package Planilha.Controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

import Planilha.Model.Clientes;

import java.util.ArrayList;
import java.util.List;

// Jasper Reports
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class ClienteRelatorio {
     
    private String path; //Caminho Base
    private String pack;
    private String arquivo = "jasper/Clientes.jrxml";

    public ClienteRelatorio(){

        try{
        InputStream is = getFileFromResourceAsStream(arquivo);
        this.pack  = this.getClass().getPackage().toString();
        this.path = this.getClass().getResource("").getPath();
        //this.path = this.getClass().getRealPath();
        System.out.println("Path    - " + this.path);
        System.out.println("Package - " + this.pack);
        //printInputStream(is);

        

        // Gerar a Base para o jasper
        List<Clientes> clientes = new ArrayList<Clientes>();

        Clientes cliente1 = new Clientes();
        Clientes cliente2 = new Clientes();
        Clientes cliente3 = new Clientes();

        cliente1.setNome("Guilherme Gois Braga de Medeiros");
        cliente2.setNome("Lais Gois Braga");
        cliente3.setNome("Ravi Gois Braga");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        imprimir(clientes);
        }catch(Exception e ){
            e.printStackTrace();
        }

    }


    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }


    // print input stream
    private static void printInputStream(InputStream is) {

        try (InputStreamReader streamReader =
                    new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /* Imprimir o Jasper Report */
    public void imprimir(List<Clientes> clientes) throws Exception{
        JasperReport report = JasperCompileManager.compileReport(getFileFromResourceAsStream(arquivo));
   
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clientes));

        JasperExportManager.exportReportToPdfFile(print, "/home/Relatorio_de_Clientes.pdf");	
    
        System.out.println("Passou!");
    }


}