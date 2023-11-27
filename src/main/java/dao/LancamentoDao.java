package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Lancamento;
import util.JPAUtil;

public class LancamentoDao {
	
public static void salvar(Lancamento j) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Lancamento j) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(j);
		em.getTransaction().commit();
		em.close();
	}

	public static void deletar(Lancamento j) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		j = em.find(Lancamento.class, j.getId());
		em.remove(j);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static List<Lancamento> listarTodos() {
		
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select j from Lancamento j");
		@SuppressWarnings("unchecked")
		List<Lancamento> list = q.getResultList();
		em.close();
		return list;
	}
	
	
	public static Lancamento listarPorId(Integer id) {
	
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		Lancamento j = em.find(Lancamento.class, id);
		em.close();
		return j;
	}	
	
	

}
