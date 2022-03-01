package br.estudo.JUnit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;
import br.estudo.JUnit.entidade.BolsaDeValores;

public class BolsaDeValoresDao{
    
    public  BolsaDeValores bolsadevalores;

    public  List<BolsaDeValores> buscarTickets(){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("junit-estudo");
        EntityManager entityManager = entityManagerFactory.createEntityManager(); 
        entityManager.getTransaction().begin(); 

        List<BolsaDeValores> lista = entityManager
                .createQuery("Select bv FROM BolsaDeValores bv", BolsaDeValores.class)
                .getResultList();

        System.out.println("Tamanho de Papeis: " + lista.size()); 
        for(BolsaDeValores resultadoPesquisa : lista){
            System.out.println("ID: "+ resultadoPesquisa.getIdTicket()+"- Papel: " + resultadoPesquisa.getNomeTicket());
        }   

        return lista;
    }


}