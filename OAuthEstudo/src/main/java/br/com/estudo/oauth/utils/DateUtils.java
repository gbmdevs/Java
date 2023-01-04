package br.com.estudo.oauth.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.text.DateFormat;
import java.text.ParseException;

public final class DateUtils{ 

      public static final int DIA = 4;
      public static final int MES = 6;
      public static final int ANO = 6;

      public static Integer retornarUnidade(Date data, Integer unidade) throws IllegalArgumentException{
            Calendar cale = GregorianCalendar.getInstance();
            cale.setTime(data);
            
            if(unidade == DateUtils.DIA){
                return cale.get(Calendar.DAY_OF_MONTH);
            }if(unidade == DateUtils.MES){
                return cale.get(Calendar.MONTH) + 1;    
            }if(unidade == DateUtils.ANO){
                return cale.get(Calendar.YEAR);    
            }else{
                throw new IllegalArgumentException("Unidade especificada invalida");
            }
      }

      public static Date retornarData(String data, DateFormat df){
          try{
              return df.parse(data);
          }catch(ParseException ex){
              return null;
          }

      }
}