package br.estudo.JUnit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.estudo.JUnit.entidade.HistoricoBolsaValores;

public class HistoricoBolsaValoresDao{


    public void inserirHistoricoBolsaValores(HistoricoBolsaValores historico){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("junit-estudo");
        EntityManager entityManager = entityManagerFactory.createEntityManager(); 
        entityManager.getTransaction().begin(); 

        entityManager.persist(historico);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


    }

}