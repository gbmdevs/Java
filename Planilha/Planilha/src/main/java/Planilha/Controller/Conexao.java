package Planilha.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class Conexao {
    String driver = "org.postgresql.Driver";
    String user   = "postgres";
    String pass   = "example";
    String url    = "jdbc:postgresql://172.20.0.9:5432/postgres"; 
    String status = "";
    String sql    = ""; 
    Connection con = null;     
    PreparedStatement stmt = null;

    public Conexao(){
       try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass); 
            status = "Executado OK";
            
       }catch(Exception e){
            System.out.println(e);
            status = "Falha durante a chamada!";
       }   
    }
    
}