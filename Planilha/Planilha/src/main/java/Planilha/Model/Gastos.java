package Planilha.Model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Gastos {
    private Integer id;
    private String spentDescription;
    private Double spentValue;
    //private Date dateSpent;
    private int cdTipSpent;
    private Date dateSpent;

public Gastos(){

}   

public Gastos(Integer id , String spentDescription,
               Double spentValue, int cdTipSpent,
               Date dateSpent){
    this.id               = id ;
    this.spentDescription = spentDescription;
    this.spentValue       = spentValue;
    this.cdTipSpent       = cdTipSpent;
    this.dateSpent        = dateSpent;
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
public void setCdIdSpent(Integer cdtipspent){
    this.cdTipSpent = cdtipspent;
}

public Integer getCdIdSpent(){
    return this.cdTipSpent;
}

public void setDateSpent( Date dateSpent){
    this.dateSpent = dateSpent;
}

public String getDateSpent(){
    return this.dateSpent.toString(); 
}

}