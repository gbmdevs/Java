package Planilha.Model;

import java.util.Date;

public class Datas{

    private String dataAtual; 
    private String dataUlt12Mes;
    private String dataProxMes;

    public Datas(){
        this.dataAtual    = "";
        this.dataUlt12Mes = "";
        this.dataProxMes  = "";
    }

    public Datas(String dataAtual, 
                 String dataUlt12Mes,
                 String dataProxMes){
        this.dataAtual    = dataAtual;
        this.dataUlt12Mes = dataUlt12Mes;
        this.dataProxMes  = dataProxMes;
    }


    public void setDataAtual(String dataAtual){
        this.dataAtual = dataAtual;
    }

    public String getDataAtual(){
        return this.dataAtual;
    } 

    public void setDataUlt12Mes(String dataUlt12Mes){
        this.dataUlt12Mes = dataUlt12Mes;
    }

    public String getDataUlt12Mes(){
        return this.dataUlt12Mes;
    }

    public String getDataProxMes(){
        return this.dataProxMes;
    }
    public void setDataProxMes(String dataProxMes){
        this.dataProxMes = dataProxMes;
    }

    
    @Override
    public String toString(){
        return "Datas = [ dataAtual: " + this.dataAtual + "," +
        "dataUlt12Mes: " + this.dataUlt12Mes + "," +
        "dataProxMes: " + this.dataProxMes +
        "]";
    }

}