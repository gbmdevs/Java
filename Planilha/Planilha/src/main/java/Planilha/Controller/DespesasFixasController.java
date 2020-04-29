package Planilha.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Planilha.Model.DespesasFixas;

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


}