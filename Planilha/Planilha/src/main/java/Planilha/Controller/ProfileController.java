package Planilha.Controller;

// SQL 
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Model
import Planilha.Model.DespesasFixas;
import Planilha.Model.Gastos;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

 

public class ProfileController {
    
     private Double totalSalaryAccount;
     private Double totalSalaryFree;
     private List<Gastos> spents; 
     private List<DespesasFixas> despesas;
    

//Get and Setters  - Profile     
public ProfileController(){

}

public void setTotalSalaryAcc(Double totalSalaryAcc){
    this.totalSalaryAccount = totalSalaryAcc;
}

public Double getTotalSalaAcc(){
    return this.totalSalaryAccount;
}


public Double getTotalSalaryFree(){
    return this.totalSalaryFree;
}

public void setTotalSalaryFree(Double totalSalaryFree){
    this.totalSalaryFree = totalSalaryFree;
}

public void setSpents(List<Gastos> spents){
    this.spents = spents;
}

public List<Gastos> getSpents(){
    return this.spents;
}

public void setDespesas(List<DespesasFixas> despesas){
    this.despesas = despesas;
}

public List<DespesasFixas> getDespesas(){
    return this.despesas;
}

public void addTotalSalaryAccount(Double spentValue){
  this.totalSalaryAccount += spentValue;
}

public void buscaGastos() throws SQLException{
    this.setTotalSalaryAcc(0.0);
    List<Gastos>  listGas = new ArrayList<Gastos>();
    Conexao conecta = new Conexao();  
    conecta.sql = "Select * from gastos";
    conecta.stmt = conecta.con.prepareStatement(conecta.sql);
    ResultSet rs = conecta.stmt.executeQuery();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    while(rs.next()){ 
      listGas.add(new Gastos(
         rs.getInt("idspent"),
         rs.getString("spentdescription"),
         rs.getDouble("spentvalue"),
         rs.getInt("spenttype"),
         rs.getDate("datespent")
         ));   
         this.addTotalSalaryAccount(
                rs.getDouble("spentvalue"));
    }
    conecta.con.close();
    this.setSpents(listGas);  
}

   public void buscaDespesas() throws SQLException{
      this.totalSalaryFree = 0.0;
      char status; 
      setTotalSalaryFree(totalSalaryAccount);
      Conexao conecta = new Conexao();   
      List<DespesasFixas> listDes = new ArrayList<DespesasFixas>(); 
      conecta.sql = "SELECT b.titleexpenses, " +
                    "a.valueexpenses, " +
                    "a.duedate, " +
                    "a.sitpayment, " +   
                    "a.idexpenses " +
                    "FROM despesasFixas a, " +
                    " tipdespesas   b " +
                    " WHERE a.idtipexpenses = b.idtipexpenses ";
      conecta.stmt = conecta.con.prepareStatement(conecta.sql);
      ResultSet rs = conecta.stmt.executeQuery();
      
      while(rs.next()){ 
        status = rs.getString("sitpayment").charAt(0);
        listDes.add(new DespesasFixas(
           rs.getInt("idexpenses"),
           rs.getString("titleexpenses"),
           rs.getDouble("valueexpenses"),
           rs.getDate("duedate"),
           rs.getString("sitpayment")) 
           
        );
        System.out.println(status);
        if(status == 'N'){
            System.out.println("Entrou aqui");
            this.totalSalaryFree = this.totalSalaryFree
              -  rs.getDouble("valueexpenses");
        }

      }

      this.setDespesas(listDes);

   }


}