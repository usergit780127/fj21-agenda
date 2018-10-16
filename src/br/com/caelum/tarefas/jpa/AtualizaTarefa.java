package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;


public class AtualizaTarefa {
	
	public static void main(String[] args) {
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId((long) 1); // id que ja existe no banco
		tarefa.setDescricao("Atualizando descricao 1");
		tarefa.setFinalizado(false);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(tarefa); // atualiza
		manager.getTransaction().commit();
		
	}

}
