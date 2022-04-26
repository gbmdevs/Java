package br.banco.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public  class ConnectionFactory{
      
      private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("planilha-funcional");

      public static EntityManager getEntityManager(){
		     return factory.createEntityManager();
	  }

}