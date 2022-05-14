package br.banco.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import java.lang.reflect.ParameterizedType;

import java.util.List;

import javax.inject.Inject;

public class DaoGenerico<T extends EntidadeBase> {
	

	@PersistenceContext
	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public T findById(Class<T> clazz, Long id){
		System.out.println("Etrnou no find");
		return manager.find(clazz, id);
	}

    public List findAll(Class<T> clazz){
		
        System.out.println("Entrou no findALl"+ clazz.getSimpleName());
		Query query = manager.createQuery("from " + clazz.getSimpleName());
		List<T> objects = query.getResultList();
		return objects;
	}


	public void salvar(T obj){
	   manager.getTransaction().begin();
	   manager.persist(obj);
	   manager.getTransaction().commit();
	   System.out.println("Entrou!");
	}

}