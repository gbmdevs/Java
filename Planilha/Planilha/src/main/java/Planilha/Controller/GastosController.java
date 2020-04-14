package Planilha.Controller;

import Planilha.Model.Gastos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List; 
import java.sql.PreparedStatement;

// Controllers 
import Planilha.Controller.Conexao;

public class GastosController {
   
    private Double totalSpent;
  //  private Date dataAtual;
    private List<Gastos> gastos;

 
public void setGastos(List<Gastos> gastos){
    this.gastos = gastos;
}

public void setTotalSpent(Double totalSpent){
    this.totalSpent = totalSpent;
}


public void buscaGastos() throws SQLException{
      Conexao conecta = new Conexao();  
      conecta.sql = "Select * from gastos";
      conecta.stmt = conecta.con.prepareStatement(conecta.sql);
      ResultSet rs = conecta.stmt.executeQuery();

      while(rs.next()){
        System.out.println(rs.getString("spentdescription"));
      }

}

}