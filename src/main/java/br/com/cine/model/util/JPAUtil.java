package br.com.cine.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("cine");

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public static void closeEntityManager() {
		entityManagerFactory.close();
	}
}
