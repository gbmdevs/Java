package BancoTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import br.banco.util.CarregarTabelas;
import br.banco.util.ResourceFile;
import br.banco.util.DAOAbstratoJPA;

import br.banco.entidade.TipoEstrategia;
import br.banco.json.TestObjeto;

import java.util.List;

import java.io.IOException;

public class BancoTest {


     private static final String TEST_OBJECT_JSON_RESOURCE_FILE = "cargaEstrategia.json";

    @Test
    public void shouldAnswerWithTrue()
    {
        //new CarregarTabelas().carregarTabela("cargaEstrategia.json", TestObjeto.class);
    }

    @Test
    public void carregarListaDeJSONLista()  throws IOException{
        ResourceFile jsonResourceFile = new ResourceFile(TEST_OBJECT_JSON_RESOURCE_FILE);
        List<TestObjeto> lista = jsonResourceFile.fromJsonAsList(TestObjeto[].class);
        System.out.println("Tamanho: " + lista.size());
        //new CarregarTabelas().carregarTabela(lista, TestObjeto.class);
        //new DAOAbstratoJPA<TestObjeto>();

    }
}