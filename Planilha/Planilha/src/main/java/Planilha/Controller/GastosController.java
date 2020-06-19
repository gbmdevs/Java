package Planilha.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

//Config
import Planilha.Controller.Conexao;

//Model
import Planilha.Model.Gastos;

public class GastosController{
    private Gastos gastos;
    private ObjectMapper mapper  = new ObjectMapper(); 

public void  setGastosController(Gastos gastos){
    this.gastos = gastos;
}

public Gastos getGastosController(){
    return this.gastos;
}


// CRUD - Modelo de Gastos
public String insertSpent(Gastos gastos){ 
       
    int idspent = this.retornaMax(); 
    /*
    try{
            Conexao conexao = new Conexao();
            conexao.sql = "INSERT INTO gastos(spentdescription," +
            "spentvalue,spenttype,datespent,idspent) values(?,?,?,?,?)";
            conexao.stmt = conexao.con.prepareStatement(conexao.sql);
            conexao.stmt.setString(1, gastos.getSpentDescription());
            conexao.stmt.setDouble(2, gastos.getSpentValue());
            conexao.stmt.setInt(3,gastos.getcdTipSpent());
            conexao.stmt.setDate(4, new java.sql.Date(gastos.getFormatDateSpent().getTime()));
            conexao.stmt.setInt(5, idspent);
            conexao.stmt.executeUpdate();
            conexao.stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        } */
        
        return "{ 'status' : 200 }";
}



public int retornaMax(){
    int max = 0;
    try{
       Conexao conexao = new Conexao();
       conexao.sql = "select max(idspent) from gastos";
       conexao.stmt = conexao.con.prepareStatement(conexao.sql);
       ResultSet rs = conexao.stmt.executeQuery();
       while(rs.next()){
           max = rs.getInt(1);
           max++;
       }
       conexao.con.close();

    }catch(Exception e){
        e.printStackTrace();
    }
   
    return max;
}

}