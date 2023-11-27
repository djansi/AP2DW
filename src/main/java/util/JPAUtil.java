package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AP2LANCAMENTO");
	
	//Método estático para criar uma instância da fábrica de EntityManager
	public static EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}
}


