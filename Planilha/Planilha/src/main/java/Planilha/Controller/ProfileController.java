package Planilha.Controller;

// SQL 
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Planilha.Model.Gastos;

public class ProfileController {
    
     private Double totalSalaryAccount;
     private List<Gastos> spents; 
    

//Get and Setters  - Profile     
public ProfileController(){

}

public void setTotalSalaryAcc(Double totalSalaryAcc){
    this.totalSalaryAccount = totalSalaryAcc;
}

public Double getTotalSalaAcc(){
    return this.totalSalaryAccount;
}

public void setSpents(List<Gastos> spents){
    this.spents = spents;
}

public List<Gastos> getSpents(){
    return this.spents;
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

    while(rs.next()){ 
      listGas.add(new Gastos(
         rs.getInt("idspent"),
         rs.getString("spentdescription"),
         rs.getDouble("spentvalue"),
         rs.getInt("spenttype")
         ));  
         this.addTotalSalaryAccount(
                rs.getDouble("spentvalue"));
    }
     
    this.setSpents(listGas); 
}

}