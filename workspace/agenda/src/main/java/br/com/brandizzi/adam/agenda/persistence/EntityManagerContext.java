package br.com.brandizzi.adam.agenda.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerContext implements AutoCloseable {

	private static EntityManagerFactory entityManagerFactory = null;

	private EntityManager entityManager;

	public EntityManagerContext() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("agenda");
		}

		entityManager = entityManagerFactory.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void close() throws Exception {
		entityManager.close();
	}

}
