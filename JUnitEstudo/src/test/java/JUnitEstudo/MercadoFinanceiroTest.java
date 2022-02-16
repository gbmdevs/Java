package JUnitEstudo;

import br.estudo.JUnit.api.DadosMercadoFinanceiro;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MercadoFinanceiroTest {

    @Test
    public void shouldAnswerWithTrue()
    {
        DadosMercadoFinanceiro data = new DadosMercadoFinanceiro();
        data.buscarDadosHistoricoAtivo();

        assertTrue( true );
    }

}