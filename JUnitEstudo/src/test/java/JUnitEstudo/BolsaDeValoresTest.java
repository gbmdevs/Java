
package JUnitEstudo;

import br.estudo.JUnit.entidade.BolsaDeValores;
import br.estudo.JUnit.dao.BolsaDeValoresDao;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BolsaDeValoresTest {

    @Test
    public void buscarPapelBolsaDeValores(){
         BolsaDeValoresDao bolsaDao = new BolsaDeValoresDao();
         bolsaDao.buscarTickets();
    }

    /*
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

        BolsaDeValores bolsa1 = new BolsaDeValores();
        bolsa1.setNomeTicket("BBAS3");
        bolsa1.setDescricaoTicket("Banco do Brasil SA");
        bolsa1.setNomeBalcao("SAO");

        BolsaDeValores bolsa2 = new BolsaDeValores();
        bolsa2.setNomeTicket("USIM5");
        bolsa2.setDescricaoTicket("Usinas Siderurgicas de Minas Gerais A Pref Shs");
        bolsa2.setNomeBalcao("SAO");
        
        BolsaDeValores bolsa3 = new BolsaDeValores();
        bolsa3.setNomeTicket("B3SA3");
        bolsa3.setDescricaoTicket("B3 SA - Brasil Bolsa Balcao");
        bolsa3.setNomeBalcao("SAO");

        BolsaDeValores bolsa4 = new BolsaDeValores();
        bolsa4.setNomeTicket("ITSA4");
        bolsa4.setDescricaoTicket("Itausa SA Preference Shares");
        bolsa4.setNomeBalcao("SAO");

        entityManager.persist(bolsa);
        entityManager.persist(bolsa1);
        entityManager.persist(bolsa2);
        entityManager.persist(bolsa3);
        entityManager.persist(bolsa4);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        }catch(Exception ex){
            //System.out.println("Ja Existe");
            ex.printStackTrace();
        }
    }*/



}   