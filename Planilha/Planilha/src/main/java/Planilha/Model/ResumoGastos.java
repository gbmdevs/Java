package Planilha.Model;

public class ResumoGastos { 
     private String titletypespent;
     private Double valuespent;  

    public ResumoGastos(){

    }
    public ResumoGastos(String titletypespent, Double valuespent ){
        this.titletypespent = titletypespent;
        this.valuespent = valuespent;
    }
     
    
    //Get & Set -> titletypespent
       public void setTitleTypeSpent(String titletypespent){
        this.titletypespent = titletypespent;
    }
    public String getTitleTypeSpent(){
        return this.titletypespent;
    }
    
    //Get & Set -> valuespent
    public void setValueSpent(Double valuespent){
        this.valuespent = valuespent;
    }
    public Double getValueSpent(){
        return this.valuespent;
    }

}  


