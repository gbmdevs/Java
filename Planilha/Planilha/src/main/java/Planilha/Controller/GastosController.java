package Planilha.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
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
      
  //  System.out.println(gastos.toString());
     
    try{
            Conexao conexao = new Conexao();
            conexao.sql = "INSERT INTO gastos(spentdescription," +
            "spentvalue,spenttype,datespent) values(?,?,?,?)";
            conexao.stmt = conexao.con.prepareStatement(conexao.sql);
            conexao.stmt.setString(1, gastos.getSpentDescription());
            conexao.stmt.setDouble(2, gastos.getSpentValue());
            conexao.stmt.setInt(3,gastos.getcdTipSpent());
            conexao.stmt.setDate(4, new java.sql.Date(gastos.getFormatDateSpent().getTime()));
            conexao.stmt.executeUpdate();
            conexao.stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        } 
        
        return "{ status: 200 }";
}


}