
package br.com.requisicao.requisicoes;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import br.banco.entidade.TipoEstrategia;

import br.com.requisicao.dto.Estudante;

import br.com.requisicao.util.ConverteJSON;

import javax.inject.Inject;

import  br.banco.util.DaoGenerico;

import java.util.List;

@Path("/tipoestrategia")
public class DetalhaTipoEstrategia extends ConverteJSON{
 
     
     @GET
     public String buscarTiposEstrategias(){
           TipoEstrategia estudante = new TipoEstrategia();
           // Buscar todos os dados do tipo Estrategia
           DaoGenerico<TipoEstrategia> dao = new DaoGenerico<TipoEstrategia>();
           List<TipoEstrategia> lista = dao.findAll(TipoEstrategia.class);

           return new ConverteJSON().retornaJSON(lista);

     }

}
