package br.banco.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoGenerico<T extends EntidadeBase> {
	
	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public T findById(Class<T> clazz, Long id){
		return manager.find(clazz, id);
	}

	public void salvar(T obj){
	   manager.getTransaction().begin();
	   manager.persist(obj);
	   manager.getTransaction().commit();
	   System.out.println("Entrou!");
	}
}