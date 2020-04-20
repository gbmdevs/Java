package Planilha.Model;

import java.util.Date;

public class DespesasFixas {
   
   private Integer idExpenses; 
   private String  titleExpenses;
   private Double  valueExpenses;
   private Date    dueDate;
   private String  sitPayment;


   public DespesasFixas( Integer idExpenses,String titleExpenses, Double valueExpenses,
                        Date dueDate, String sitPayment){
      this.titleExpenses = titleExpenses;
      this.valueExpenses = valueExpenses;
      this.dueDate  = dueDate;
      this.sitPayment = sitPayment;
      this.idExpenses = idExpenses;
   }
 
   public void setIdExpenses(Integer idExpenses){
       this.idExpenses = idExpenses;
   }

   public Integer getIdExpenses(){
       return this.idExpenses;
   }

   public void setTitleExpenses(String titleExpenses){
       this.titleExpenses = titleExpenses;
   }
   
   public String getTitleExpenses(){
       return this.titleExpenses;
   }
    
   public void setValueExpenses(Double valueExpenses){
       this.valueExpenses = valueExpenses;
   }

   public Double getValueExpenses(){
       return this.valueExpenses;
   }
   
   public void setDueDate(Date dueDate){
       this.dueDate = dueDate;
   }
   public String getDueDate(){
       return this.dueDate.toString();
   }
    
   public String getSitPayment(){
       return this.sitPayment;
   }
   public void setSitPayment(String sitPayment){
       this.sitPayment = sitPayment;
   }

}