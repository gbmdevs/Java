
package JUnitEstudo;

import br.estudo.JUnit.entidade.BolsaDeValores;
import br.estudo.JUnit.dao.BolsaDeValoresDao;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BolsaDeValoresTest {

    @Test
    public void buscarPapelBolsaDeValores(){
         BolsaDeValoresDao bolsaDao = new BolsaDeValoresDao();
         bolsaDao.buscarTickets();
    }

    @Test
    public void inserirPapelBolsaDeValores(){
        try{
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("junit-estudo");
        EntityManager entityManager = entityManagerFactory.createEntityManager(); 
          
        entityManager.getTransaction().begin();  

        BolsaDeValores bolsa = new BolsaDeValores();
        bolsa.setNomeTicket("BBSE3");
        bolsa.setDescricaoTicket("BB Seguridade");
        bolsa.setNomeBalcao("SAO");
        entityManager.persist(bolsa);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        }catch(Exception ex){
            System.out.println("Ja Existe");
        }


    }



}   