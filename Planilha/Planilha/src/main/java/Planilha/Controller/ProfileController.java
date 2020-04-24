package Planilha.Controller;

// SQL 
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

//Model
import Planilha.Model.DespesasFixas;
import Planilha.Model.Gastos;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

 

public class ProfileController {
    
     private Double totalSalaryAccount;
     private Double totalSalaryFree;
     private List<Gastos> spents; 
     private List<DespesasFixas> despesas;
     private Map<String,Double> sumSpentsList;
    

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

public void setSumSpentList(Map<String,Double> sumSpentsList){
    this.sumSpentsList = sumSpentsList;
}

public Map<String,Double> getSumSpentsList(){
    return this.sumSpentsList;
}


public void buscaGastosListTipo() throws SQLException{
    Conexao conexao = new Conexao();
    Map<String,Double> soma = new HashMap<String,Double>();
    conexao.sql = "select spenttype,sum(spentvalue) " + 
                  " from gastos " +
                  " group by spenttype";
    conexao.stmt = conexao.con.prepareStatement(conexao.sql);              
    ResultSet rs = conexao.stmt.executeQuery();
    while(rs.next()){
        soma.put(rs.getString("spenttype"),rs.getDouble("sum"));
    }
    this.setSumSpentList(soma);
}

public Double totalSalarySum(Integer spenttype) throws SQLException{
    Conexao conexao = new Conexao();
    conexao.sql = "Select sum(spentvalue) from gastos " +
                  "where spenttype = " + spenttype;
    conexao.stmt = conexao.con.prepareStatement(conexao.sql);
    ResultSet rs = conexao.stmt.executeQuery();
    rs.next();
    String soma = rs.getString(1);
    return Double.parseDouble(soma);
}

public void buscaGastos(Integer tipgastos) throws SQLException{
    this.setTotalSalaryAcc(totalSalarySum(1));
    this.buscaGastosListTipo();
    List<Gastos>  listGas = new ArrayList<Gastos>();
    Conexao conecta = new Conexao();  
    conecta.sql = "Select * from gastos " + 
                   "Where spenttype = " + tipgastos;
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
    }
    conecta.con.close();
    this.setSpents(listGas);  
}

   public void buscaDespesas() throws SQLException{
      Calendar c = Calendar.getInstance();
      Date date = c.getTime();
      System.out.println(date.toString()); 
      
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
        if(status == 'N'){ 
            this.totalSalaryFree = this.totalSalaryFree
              -  rs.getDouble("valueexpenses");
        }

      }

      this.setDespesas(listDes);

   }


}