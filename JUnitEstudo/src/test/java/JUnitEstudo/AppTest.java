package JUnitEstudo;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void verificaEntidade(){
          EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("junit-estudo");
          EntityManager entityManager = entityManagerFactory.createEntityManager();
    }
}
