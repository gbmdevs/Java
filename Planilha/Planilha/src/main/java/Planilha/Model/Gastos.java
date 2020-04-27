package Planilha.Model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Gastos {
    private Integer id;
    private String spentDescription;
    private Double spentValue; 
    private Integer cdTipSpent;
    private Date dateSpent;

public Gastos(){

}   

public Gastos(Integer id , String spentDescription,
               Double spentValue, Integer cdTipSpent,
               Date dateSpent){
    this.id               = id ;
    this.spentDescription = spentDescription;
    this.spentValue       = spentValue;
    this.cdTipSpent       = cdTipSpent;
    this.dateSpent        = dateSpent;
}

public Gastos(String spentDescription,
              Double spentValue, Integer cdTipSpent,
              Date dateSpent ){
    this.spentDescription = spentDescription;
    this.spentValue = spentValue;
    this.cdTipSpent = cdTipSpent;
    this.dateSpent = dateSpent;              
}

public String getSpentDescription() {
    return this.spentDescription;
}

public void setSpentDescription(String spentDescription){
    this.spentDescription = spentDescription;
}

public void setSpentValue( Double spentValue){
    this.spentValue = spentValue;
}

public Double getSpentValue(){
    return this.spentValue;
}

// ID 
public void setId(Integer id){
    this.id = id;
}

public Integer getId(){
    return this.id;
}

//CDTIPSPENT
public void setcdTipSpent(Integer cdTipSpent){
    this.cdTipSpent = cdTipSpent;
}

public Integer getcdTipSpent(){
    return this.cdTipSpent;
}

public void setDateSpent( Date dateSpent){
    this.dateSpent = dateSpent;
}

public String getDateSpent(){
    return this.dateSpent.toString(); 
}

public Date getFormatDateSpent(){
    return this.dateSpent;
}

@Override
public String toString(){
   return "Gastos [ id = " + this.id + ","
   + "spentdescription = " + this.spentDescription + ","
   + "spentValue = " + this.spentValue + ","
   + "dateSpent  = " + this.dateSpent  + ","
   + "cdTipSpent = " + this.cdTipSpent  
   + " ]";
}


}