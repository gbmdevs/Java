package Planilha.Model;


public class GraficoDespesasFixas {
        private String nomeDespesaFixa;
        private Double valorDespesaFixa;

// Iniciar as Variaveis
public GraficoDespesasFixas(){

} 

public GraficoDespesasFixas(String nomeDespesaFixa, Double valorDespesaFixa ){
    this.nomeDespesaFixa  = nomeDespesaFixa;
    this.valorDespesaFixa = valorDespesaFixa; 
} 

// GET and SETTERS
public void setNomeDespesaFixa(String nomeDespesaFixa){
        this.nomeDespesaFixa = nomeDespesaFixa;
}

public String getNomeDespesaFixa(){
        return this.nomeDespesaFixa ;
}


public void setValorDespesaFixa(Double valorDespesaFixa){
        this.valorDespesaFixa = valorDespesaFixa;
}

public Double getValorDespesaFixa(){
        return valorDespesaFixa;
}


}   