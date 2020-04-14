package Planilha.Model;

import java.util.List; 
import Planilha.Model.Gastos;

public class Profile {
    
     private Double totalSalaryAccount;
     private List<Gastos> spents; 
    

//Get and Setters  - Profile     
public Profile(){

}

public void setTotalSalaryAcc(Double totalSalaAcc){
    this.totalSalaryAccount = totalSalaAcc;
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



}