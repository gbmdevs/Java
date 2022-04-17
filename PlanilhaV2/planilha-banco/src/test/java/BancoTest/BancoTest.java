package BancoTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import br.banco.util.CarregarTabelas;

import br.banco.entidade.tipoEstrategia;

public class BancoTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        new CarregarTabelas().carregarTabela("cargaEstrategia.json", tipoEstrategia.class);
    }
}