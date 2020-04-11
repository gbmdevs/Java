package Planilha.Model;

public class Gastos {
    private Integer id;
    private String spentDescription;
    private Double spentValue;


public Gastos(){

}   

public Gastos(Integer id , String spentDescription, Double spentValue){
    this.id = id ;
    this.spentDescription = spentDescription;
    this.spentValue = spentValue;
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

}