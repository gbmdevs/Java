package Planilha.Model;


public class GraficoDespesasFixas {
        private String nomeDespesaFixa;
        private Double valorDespesaFixa;
        private String dataDespesaFixa;

// Iniciar as Variaveis
public GraficoDespesasFixas(){

} 

public GraficoDespesasFixas(String nomeDespesaFixa, 
                           Double valorDespesaFixa, 
                        String dataDespesaFixa){
    this.nomeDespesaFixa  = nomeDespesaFixa;
    this.valorDespesaFixa = valorDespesaFixa; 
    this.dataDespesaFixa  = dataDespesaFixa;
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

public String getDataDespesaFixa(){
        return dataDespesaFixa;
}

public void setDataDespesaFixa(String dataDespesaFixa){
        this.dataDespesaFixa = dataDespesaFixa;
}


}   