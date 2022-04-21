package br.banco.util;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {
    void setClasse(Class< T > clazzToSet);

    void create(final T entity);

}