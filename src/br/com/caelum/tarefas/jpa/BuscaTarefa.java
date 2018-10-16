package br.com.caelum.tarefas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.tarefas.modelo.Tarefa;

// busca com JPQL, linguagem do JPA para queries
public class BuscaTarefa {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select t from Tarefa as t where t.finalizado = :paramFinalizado");
		query.setParameter("paramFinalizado", false); // parametro que mostrara as tarefas finalizadas = false
		
		@SuppressWarnings("unchecked")
		List<Tarefa> lista = query.getResultList(); // lista das tarefas encontradas
		
		for (Tarefa t : lista) {
			System.out.println(t.getDescricao());
		}
		
		manager.close();
	}

}
