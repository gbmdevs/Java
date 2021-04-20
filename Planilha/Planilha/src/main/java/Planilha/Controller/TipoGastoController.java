package Planilha.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Planilha.Model.TipoGasto;

public class TipoGastoController 
{
   // Construtor

   public TipoGastoController(){

   }

   // Listar Tipo Gasto
   public String listarTipoGasto(){
    String jsonret = "";
    ObjectMapper mapper  = new ObjectMapper(); 
    
    List<TipoGasto> listipogas = new ArrayList<TipoGasto>();

    try{  
       Conexao conexao = new Conexao();
       conexao.sql =
        "Select idtypespent,titletypespent,desctypespent from tipogasto where isactive = 'S'";
        conexao.stmt = conexao.con.prepareStatement(conexao.sql);
        ResultSet rs = conexao.stmt.executeQuery();
        while(rs.next()){
            listipogas.add(new TipoGasto(
                rs.getInt("idtypespent"),
                rs.getString("titletypespent"),
                rs.getString("desctypespent")));
        }
        
        try{
            jsonret = mapper.writeValueAsString(listipogas);
        }catch(IOException e){
            e.printStackTrace();
        }
       
    }catch(SQLException e ){
        e.printStackTrace();
    }
    return jsonret;
 }
}