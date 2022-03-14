package br.estudo.JUnit.rest;

import br.estudo.JUnit.json.DadosMercadoFinanceiroUsuario;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/mercadoFinanceiro")
public class DetalhesMercadoFinanceiro {
 
     @GET
     @Produces("application/json")
     public DadosMercadoFinanceiroUsuario  buscarPosicoesUsuario(){
           return new DadosMercadoFinanceiroUsuario("Jamal",15.00);
     }

}
