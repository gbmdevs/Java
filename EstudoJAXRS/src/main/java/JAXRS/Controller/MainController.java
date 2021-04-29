package JAXRS.Controller;

//Utilitarios
import java.util.List;

//Controles
import JAXRS.Controller.PessoaRepository;

// Modelos
import JAXRS.Model.Pessoa;

// Arquivos para o JAX-RS
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class MainController{

    private PessoaRepository _repositorio = new PessoaRepository();

    // Recebe apenas chamada sem parametro: busca todos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> get(){
        return _repositorio.GetAll();
    }

    // Filtrar pelo ID
    @GET    
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa GetById(@PathParam("id") int id){
        return _repositorio.Get(id);
    }

    // Adicionar Usuario a memoria local
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(Pessoa pessoa){
        try {
            _repositorio.Add(pessoa);
            return Response.status(Response.Status.CREATED).entity(pessoa).build();

        } catch (Exception e) { 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }



}