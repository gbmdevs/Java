package br.banco.util;

import javax.persistence.EntityManager;
import java.io.Serializable;


import javax.persistence.PersistenceContext;

public abstract class DAOAbstratoJPA<T extends Serializable> {

    private Class<T> classe;

    @PersistenceContext(unitName = "planilha-funcional")
    private EntityManager entityManager;

    public final void setClasse(final Class<T> classeToSet) {
        this.classe = classeToSet;
    }

    public void create(final T entity) {
        //entityManager.persist(entity);
        //return entity;
        System.out.println("Entrou");
    }

}