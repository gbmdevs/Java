package BancoTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import br.banco.util.CarregarTabelas;

public class BancoTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        new CarregarTabelas().carregarTabela("cargaEstrategia.json");
    }
}