package br.banco.util;

import java.io.Serializable;

public class GenericJpaDao<T extends Serializable> extends DAOAbstratoJPA<T> implements IGenericDao<T> {
    //
}