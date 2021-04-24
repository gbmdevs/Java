package JAXRS.Model;

// Estudo JAX-RS

public class Pessoa {
    private int id;
    private String nome;
    private int idade;

    public void setId( int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setNome( String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setIdade( int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return this.idade;
    }


}