package JAXRS.Controller;

import JAXRS.Model.TipDespesas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BancoRepositorio{
    
    private final EntityManagerFactory emf; 
    private final EntityManager em;

    public BancoRepositorio(){
        this.emf = Persistence.createEntityManagerFactory("PostgresDB");
        this.em  = emf.createEntityManager();
    }


    // Buscar Tipdespesas
    public TipDespesas getTipDespesaById(Integer id){ 
        return this.em.find(TipDespesas.class, 1);
    }




}