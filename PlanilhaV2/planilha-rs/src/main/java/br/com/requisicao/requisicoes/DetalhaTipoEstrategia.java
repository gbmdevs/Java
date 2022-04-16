
package br.com.requisicao.requisicoes;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import br.com.requisicao.dto.Estudante;

import br.com.requisicao.util.ConverteJSON;


@Path("/tipoestrategia")
public class DetalhaTipoEstrategia extends ConverteJSON{
 
     @GET
     public String buscarTiposEstrategias(){
           Estudante estudante = new Estudante();
           estudante.setNome("Jamal");
           return new ConverteJSON().retornaJSON(estudante);
     }

}
