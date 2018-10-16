package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.caelum.tarefas.modelo.Tarefa;

public class RemoveTarefa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa encontrada = manager.find(Tarefa.class, 2L); // busca a tarefa
		manager.getTransaction().begin();
		manager.remove(encontrada); // remove
		manager.getTransaction().commit();

	}

}
