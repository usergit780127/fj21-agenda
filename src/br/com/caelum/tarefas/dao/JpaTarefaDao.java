package br.com.caelum.tarefas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Tarefa;

// implementacao CRUD com spring e jpa

@Repository // componente Bean que sera criado pelo spring na injecao de dependencia
public class JpaTarefaDao implements TarefaDao{
	
	// atributo recebe a dependencia, conforme spring com jpa
	@PersistenceContext // essa anotacao nao pode ser feita no construtor
	EntityManager manager;

	@Override
	public Tarefa buscaPorId(Long id) {
		return manager.find(Tarefa.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarefa> lista() {
		return manager.createQuery("select t from Tarefa t").getResultList();
	}

	@Override
	public void adiciona(Tarefa tarefa) {
		manager.persist(tarefa);
	}

	@Override
	public void altera(Tarefa tarefa) {
		manager.merge(tarefa);
	}

	@Override
	public void remove(Tarefa tarefa) {
		Tarefa tarefaARemover = buscaPorId(tarefa.getId());
		manager.remove(tarefaARemover);
	}

	@Override
	public void finaliza(Long id) {
		Tarefa tarefa =	buscaPorId(id);
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
	}

}
