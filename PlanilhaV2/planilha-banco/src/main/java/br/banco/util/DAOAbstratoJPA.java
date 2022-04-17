package br.banco.util;

import javax.persistence.EntityManager;
import java.io.Serializable;

import javax.persistence.PersistenceContext;

public abstract class DAOAbstratoJPA<T extends Serializable> {

    private Class<T> classe;

    @PersistenceContext(unitName = "planilha-funcional")
    private EntityManager entityManager;

    public final void setClasee(final Class<T> classeToSet) {
        this.classe = classeToSet;
    }

    public T create(final T entity) {
        entityManager.persist(entity);
        return entity;
    }

}