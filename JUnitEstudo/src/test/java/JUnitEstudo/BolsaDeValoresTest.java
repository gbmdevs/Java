
package JUnitEstudo;

import br.estudo.JUnit.entidade.BolsaDeValores;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BolsaDeValoresTest {

    @Test
    public void buscarPapelBolsaDeValores(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("junit-estudo");
        EntityManager entityManager = entityManagerFactory.createEntityManager(); 

        entityManager.getTransaction().begin();  

        List<BolsaDeValores> listaBolsaValores = entityManager
                .createQuery("Select bv FROM BolsaDeValores bv", BolsaDeValores.class)
                .getResultList();

        System.out.println("Tamanho de Papeis: " + listaBolsaValores.size()); 
        for(BolsaDeValores resultadoPesquisa : listaBolsaValores){
            System.out.println("Papel: " + resultadoPesquisa.getNomeTicket());
        }       

    }

    @Test
    public void inserirPapelBolsaDeValores(){
        try{
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("junit-estudo");
        EntityManager entityManager = entityManagerFactory.createEntityManager(); 
          
        entityManager.getTransaction().begin();  

        BolsaDeValores bolsa = new BolsaDeValores();
        bolsa.setNomeTicket("USIM5");
        bolsa.setDescricaoTicket("Usinas Siderurgicas de Minas Gerais A Pref Shs");
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