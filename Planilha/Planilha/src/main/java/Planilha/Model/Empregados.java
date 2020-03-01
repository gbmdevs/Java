package Planilha.Model;

public class Empregados {
     private String nome;
     private double salario;
     private String cargo;

public Empregados() {

}

public String getNome() {
    return nome;
}

public void setNome(String nome){
    this.nome = nome;
}

public Double getSalario(){
    return salario;
}

public void setSalario(Double salario){
    this.salario = salario;
}

public void setCargo(String cargo){
    this.cargo = cargo;
}

public String getCargo(){
    return cargo;
}

}