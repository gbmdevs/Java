package Planilha.Controller;

import Planilha.Model.Tipdespesas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATipDespesas{

    public String buscaIdTipDespesas(Integer idtipexpenses){
        System.out.println("Entrou");
       EntityManagerFactory entityManagerFactory  = 
            Persistence.createEntityManagerFactory("Planilha-DS");
        
       EntityManager entityManager = entityManagerFactory.createEntityManager();

       System.out.println("Passou o entity");
      //Realiza a busca
      Tipdespesas tipdespesas = entityManager.find(Tipdespesas.class, 1);
      System.out.println(tipdespesas.getDescExpenses());

      entityManager.close();
      entityManagerFactory.close();

       return "{ 'id': " + idtipexpenses + "}";
    }

}