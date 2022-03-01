package JUnitEstudo;

import br.estudo.JUnit.api.DadosMercadoFinanceiro;
import br.estudo.JUnit.dao.BolsaDeValoresDao;
import br.estudo.JUnit.entidade.BolsaDeValores;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.List;


public class MercadoFinanceiroTest {

    @Test
    public void carregarCandlesgraficos()
    {
        DadosMercadoFinanceiro data = new DadosMercadoFinanceiro();
        List<BolsaDeValores> listatickets = new BolsaDeValoresDao().buscarTickets();

        for(BolsaDeValores resultadoPesquisa : listatickets){
            data.buscarDadosHistoricoAtivo(resultadoPesquisa);
        }           

        assertTrue( true );
    }

}