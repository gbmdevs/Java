package BancoTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import br.banco.util.CarregarTabelas;
import br.banco.util.ResourceFile;

import br.banco.entidade.TipoEstrategia;
import br.banco.json.TestObjeto;

import java.util.List;

import java.io.IOException;

import br.banco.util.DaoGenerico;


public class BancoTest {


    private static final String TEST_OBJECT_JSON_RESOURCE_FILE = "cargaTipoEstrategia.json";


    @Test
    public void shouldAnswerWithTrue()
    {
        //new CarregarTabelas().carregarTabela("cargaEstrategia.json", TestObjeto.class);
    }

    @Test
    public void carregarListaDeJSONLista()  throws IOException{
        ResourceFile jsonResourceFile = new ResourceFile(TEST_OBJECT_JSON_RESOURCE_FILE);
        List<TipoEstrategia> lista = jsonResourceFile.fromJsonAsList(TipoEstrategia[].class);
        DaoGenerico daoEstrategia = new DaoGenerico<TipoEstrategia>();
        for(TipoEstrategia te : lista){
           daoEstrategia.salvar(te);
        }
    }
}