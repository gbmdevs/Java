package Planilha.Model;

import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

public class Staff {
   private String name;
   private int age;
   private String[] position;              // Array
   private List<String> skills;            // List
   private Map<String, BigDecimal> salary;  // 

// Get and Setters 
public void setName(String name){
    this.name = name;
}

public String getName(){
   return this.name;
}

public void setAge(int age){
    this.age = age;
}

public int getAge(){
   return this.age;
}

public void setPosition(String[] position){
    this.position = position;
}

public String[] getPosition(){
    return this.position;
}

public void setSkills(List<String> skills){
    this.skills = skills;
}

public List<String> getSkills(){
    return this.skills;
}

public void setSalary(Map<String,BigDecimal> salary){
    this.salary = salary;
}

public Map<String,BigDecimal> getSalary(){
    return this.salary;
}

}