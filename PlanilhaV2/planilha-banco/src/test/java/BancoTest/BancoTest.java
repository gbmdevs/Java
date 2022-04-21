package BancoTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import br.banco.util.CarregarTabelas;
import br.banco.util.ResourceFile;
import br.banco.util.DAOAbstratoJPA;

import br.banco.entidade.TipoEstrategia;
import br.banco.json.TestObjeto;

import java.util.List;


import javax.inject.Inject;

import java.io.IOException;

import br.banco.util.IGenericDao;

public class BancoTest {


    private static final String TEST_OBJECT_JSON_RESOURCE_FILE = "cargaEstrategia.json";

    @Inject
    private IGenericDao dao;

    @Test
    public void shouldAnswerWithTrue()
    {
        //new CarregarTabelas().carregarTabela("cargaEstrategia.json", TestObjeto.class);
    }

    @Test
    public void carregarListaDeJSONLista()  throws IOException{
        ResourceFile jsonResourceFile = new ResourceFile(TEST_OBJECT_JSON_RESOURCE_FILE);
        List<TipoEstrategia> lista = jsonResourceFile.fromJsonAsList(TipoEstrategia[].class);
        System.out.println("Tamanho: " + lista.size());
        System.out.println("Teste1 : " + lista.get(0).getNomeEstrategia());
        dao.create(lista.get(0));
        //new CarregarTabelas().carregarTabela(lista, TestObjeto.class);
        //new DAOAbstratoJPA<TestObjeto>();

    }
}