package Planilha.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import Planilha.Model.DespesasFixas;
import Planilha.Model.GraficoDespesasFixas;


import Planilha.Controller.Conexao;

public class DespesasFixasController {
       private List<DespesasFixas>  despesasFixas = new ArrayList<DespesasFixas>();
  
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
         "where a.duedate between '2021-03-01' and '2021-04-01' " +    
         "and a.idtipexpenses = b.idtipexpenses order by a.duedate asc";
         conexao.stmt = conexao.con.prepareStatement(conexao.sql);
         ResultSet rs = conexao.stmt.executeQuery();
         while(rs.next()){
             lista.add(new GraficoDespesasFixas(
                 rs.getString("titleexpenses"),
                 rs.getDouble("valueexpenses")
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
          "where a.duedate between '2021-03-01' and '2021-04-01' " +    
          "and a.idtipexpenses = b.idtipexpenses order by a.duedate asc";
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