package Planilha.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;

import com.fasterxml.jackson.databind.ObjectMapper;

import Planilha.Model.DespesasFixas;
import Planilha.Model.GraficoDespesasFixas;
import Planilha.Model.Datas;


import Planilha.Controller.Conexao;
import Planilha.Controller.DatasController;

public class DespesasFixasController {
       private List<DespesasFixas>  despesasFixas = new ArrayList<DespesasFixas>();
       private static String DATA_INICIO = "'2023-12-01'";
       private static String DATA_FINAL  = "'2024-01-01'";
  
public void setDespesasFixas(List<DespesasFixas> despesasFixas){
    this.despesasFixas = despesasFixas;
}

public List<DespesasFixas> getDespesasFixas(){
    return this.despesasFixas;
}

public String listarDispesasFixas(){
    String jsonret = "";
    ObjectMapper mapper  = new ObjectMapper(); 
    int rowcont = 0;

    try{ 
      Conexao conexao = new Conexao();
      conexao.sql = "Select a.*,b.titleexpenses from despesasfixas a ," + 
      "tipdespesas b where a.idtipexpenses = b.idtipexpenses";
      conexao.stmt = conexao.con.prepareStatement(conexao.sql);
      ResultSet rs = conexao.stmt.executeQuery();
      while(rs.next()){
          this.despesasFixas.add(new DespesasFixas(
              rs.getInt("idexpenses"),
              rs.getString("titleexpenses"),
              rs.getDouble("valueexpenses"),
              rs.getDate("duedate"),
              rs.getString("sitpayment")
              ));
              rowcont++;
      }
      conexao.con.close();
    }catch(Exception e){
        e.printStackTrace();
    }


    try{
       jsonret = mapper.writeValueAsString(this.despesasFixas);
    }catch(IOException e ){
        e.printStackTrace();
    }
     System.out.println(rowcont);
     return jsonret;
}

// Compor Grafico DespesasFixas
public String carregarGraficoDespesasFixas() {
    ObjectMapper mapper  = new ObjectMapper(); 
    List<GraficoDespesasFixas> lista = new ArrayList<GraficoDespesasFixas>();
    String jsonret = "";
    int i = 0;
    
    try{
        Conexao conexao = new Conexao();
        conexao.sql = "select b.titleexpenses, a.valueexpenses from despesasfixas a , tipdespesas b " +
         "where a.duedate between " + DATA_INICIO +" and "+ DATA_FINAL +" " +    
         "and a.idtipexpenses = b.idtipexpenses order by a.duedate asc";
         conexao.stmt = conexao.con.prepareStatement(conexao.sql);
         ResultSet rs = conexao.stmt.executeQuery();
         while(rs.next()){
             lista.add(new GraficoDespesasFixas(
                 rs.getString("titleexpenses"),
                 rs.getDouble("valueexpenses"),
                 "DD/MM/AAAA"
             ));
         }
         conexao.con.close();

    }catch(Exception e){
        e.printStackTrace();
    }

    try{
        jsonret = mapper.writeValueAsString(lista);
    } catch(IOException e){
        e.printStackTrace();
    }
 

     return jsonret;
 }

// Carregar a Media de Gastos e Historico dos ultimos 12 meses
 public String ultimo12mesDespesaFixas(DespesasFixas despfixa){
    ObjectMapper mapper = new ObjectMapper();
    String jsonret = " ";
    List<GraficoDespesasFixas> lista = new ArrayList<GraficoDespesasFixas>();
    int i = 0;

    Datas datas = new Datas();

    // Busca a Data atual
    datas.setDataAtual(new DatasController().buscaDataAtual()); 
    datas.setDataUlt12Mes(new DatasController().buscaUltimos12Meses());
    datas.setDataProxMes(new DatasController().buscaProximoMes());
    System.out.println(datas.toString());

    try{
        Conexao conexao = new Conexao();
        conexao.sql = "select a.valueexpenses, a.duedate from despesasfixas A," + 
          "tipdespesas B where a.idtipexpenses = b.idtipexpenses and b.titleexpenses = '" + despfixa.getTitleExpenses() + "' " +  
          "and duedate between '" + datas.getDataUlt12Mes() + "' and '" + datas.getDataProxMes() + "'" +
          "order by duedate asc FETCH FIRST 50 ROWS ONLY";
         conexao.stmt = conexao.con.prepareStatement(conexao.sql);
         ResultSet rs = conexao.stmt.executeQuery();
         while(rs.next()){
             lista.add(new GraficoDespesasFixas(
                 despfixa.getTitleExpenses(),
                 rs.getDouble("valueexpenses"), 
                 retornaDataPorExtenso(rs.getDate("duedate")) 
             ));
         }
         conexao.con.close();
    }catch(Exception e){
        e.printStackTrace();
    }

    try{
        jsonret = mapper.writeValueAsString(lista);
    } catch(IOException e){
        e.printStackTrace();
    }

    return jsonret;
 }

public String retornaDataPorExtenso(Date date){ 
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    String mesExtenso =  mesPorExtenso(cal.get(Calendar.MONTH));
    int year  = cal.get(Calendar.YEAR);
    String retorno = mesExtenso + '/' + Integer.toString(year).substring(2); 
    return retorno;
}

public String mesPorExtenso(int month){
    String[] monthNames = {"JAN","FEV","MAR","ABR","MAI","JUN","JUL","AGO","SET","OUT","NOV","DEZ"};   
    return monthNames[month];
}

 public String listarDespesasFixasMes(){
      ObjectMapper mapper  = new ObjectMapper(); 
      String jsonret = "";
      List<DespesasFixas> ldesp = new ArrayList<DespesasFixas>();
      
      try{
          Conexao conexao = new Conexao();
          conexao.sql = "select a.idexpenses, " +  
          "b.titleexpenses, " +
          "a.valueexpenses, " +
          "a.duedate, " +
          "a.sitpayment " + 
          "from despesasfixas a , tipdespesas b " +
          "where a.duedate between " + DATA_INICIO + " and " + DATA_FINAL +
          " and a.idtipexpenses = b.idtipexpenses order by a.duedate asc";
          conexao.stmt = conexao.con.prepareStatement(conexao.sql);
          ResultSet rs = conexao.stmt.executeQuery(); 
          while(rs.next()){
              ldesp.add(new DespesasFixas(
                rs.getInt("idexpenses"),
                rs.getString("titleexpenses"),
                rs.getDouble("valueexpenses"),
                rs.getDate("duedate"),
                rs.getString("sitpayment")
              ));
          }
      }catch(Exception e ){
          e.printStackTrace();
      }

      //Compor o JSON da Saida
      try{
        jsonret = mapper.writeValueAsString(ldesp);
      }catch(IOException e){
          e.printStackTrace();
      }
       
      return jsonret;
}


}