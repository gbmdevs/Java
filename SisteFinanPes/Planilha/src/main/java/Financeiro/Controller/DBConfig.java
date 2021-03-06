package Financeiro.Controller;

// Postgres
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBConfig{
     // Variaveis do DB
     String driver = "org.postgresql.Driver";
     String user   = "postgres";
     String pass   = "example";
     String url    = "jdbc:postgresql://172.20.0.9:5432/postgres"; 
     String status = "";
     String sql    = "";
     PreparedStatement stmt = null;
     Connection con = null;    

     public void conexao(){
        try{
             Class.forName(driver);
             con = DriverManager.getConnection(url,user,pass);
             System.out.println("Banco de Dados Conectado");
             status = "Executado OK";
        }catch(Exception e){
             System.out.println(e);
             status = "Falha durante a chamada!";
        }      
     }

     public List<String> listarTabelas() throws SQLException{
             conexao();
             sql = "SELECT *  FROM pg_catalog.pg_tables  WHERE schemaname != 'pg_catalog'  AND schemaname != 'information_schema' ";
             stmt = this.con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
              
             List<String> lista =  new ArrayList<String>(); 
             while(rs.next()){
                   System.out.println("*---------------*");
                   System.out.println("Tabela : " + rs.getString("tablename"));
                   System.out.println("*---------------*");
                   lista.add(rs.getString("tablename"));                   
             }                 
             
             return lista;
                                
     }
     
     // Listar os valores tipo gastos
     public List<String> comboBoxTipGasto() throws SQLException{
            conexao();
            sql = "Select nometipgasto from TIP_GASTO";
            List<String> boxTipGasto = new  ArrayList<>();
            stmt = this.con.prepareStatement(sql);
            ResultSet rs  =  stmt.executeQuery();

            while(rs.next()){
            //     System.out.println(rs.getString("nometipgasto"));
                 boxTipGasto.add(rs.getString("nometipgasto"));
            }

            return boxTipGasto;
     }

}