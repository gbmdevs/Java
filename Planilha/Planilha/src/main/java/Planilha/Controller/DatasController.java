package Planilha.Controller;

import Planilha.Model.Datas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class DatasController{
    private Datas datas;

    public Datas getDatas(){
        return this.datas;
    }

    public void setDatas(Datas datas){
        this.datas = datas;
    }

    public String buscaDataAtual(){
        String mascara = "yyyy-MM-dd"; 
        SimpleDateFormat sdf = new SimpleDateFormat(mascara);
        String data = sdf.format(new Date());
        return data;
    }

    // Buscar o mês referente ao ano passado
    public String buscaUltimos12Meses(){ 
        String mascara = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(mascara);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -12);
        c.set(Calendar.DATE, 1);
        String data = sdf.format(c.getTime());
        return data;
    }

    public String buscaProximoMes(){
        String mascara = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(mascara);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, 1);
        String data = sdf.format(c.getTime());
        return data;
    }




}