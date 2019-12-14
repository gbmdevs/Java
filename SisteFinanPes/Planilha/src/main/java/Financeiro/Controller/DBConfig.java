package Financeiro.Controller;


// Postgres
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConfig{
     // Variaveis do DB
     String driver = "org.postgresql.Driver";
     String user   = "postgres";
     String pass   = "example";
     String url    = "jdbc:postgresql://172.28.0.3:5432/postgres"; 
     Connection con = null;    

     public void testaConexao(){
        try{
             Class.forName(driver);
             con = DriverManager.getConnection(url,user,pass);
             System.out.println("Banco de Dados Conectado");
        }catch(Exception e){
             System.out.println(e);
        }      
     }
}