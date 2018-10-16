package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.TarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Transactional // habilita gerenciamento de transacao configurado em spring-context 
@Controller // recebe as requisicoes e faz os redirecionamentos
public class TarefasController {

	
	@Autowired // injecao de dependencia, tirando da classe TarefasController a responsabilidade de instanciar objetos TarefaDao
	@Qualifier("jpaTarefaDao") // qualifica a dependencia que sera injetada, podendo ser jdbcTarefaDao ou jpaTarefaDao que implementam a interface TarefaDao 
	private TarefaDao dao; // usando a interface 
	
	// ao usar gerenciamento de transacao pelo spring é necessario construtor sem parametros
	public TarefasController() {
	}
	
	@RequestMapping("novaTarefa") // url sera chamada no browser
	public String form() {
		return "tarefa/formulario"; // redireciona web-inf/views/tarefa/formulario.jsp
	}
	
	// o objeto tarefa recebido sera montado pelo spring mvc ao capturar as informacoes digitadas no formulario.jsp
	@RequestMapping("adicionaTarefa") // sera chamado por formulario.jsp
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) { // anotacao avisa spring que objeto tarefa possui validacao 
		try {
			if(result.hasFieldErrors("descricao"))	{ // se houver erro na validacao para atributo descricao
				return "tarefa/formulario"; // retorna para web-inf/views/tarefa/formulario.jsp
			}
			// substituido pela injecao de dependencia
			//TarefaDao dao = new TarefaDao();
			dao.adiciona(tarefa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "tarefa/tarefa-adicionada"; // redireciona web-inf/views/tarefa/tarefa-adicionada.jsp
	}
	
	// lista as tarefas
	@RequestMapping("listaTarefas")
	public String lista(Model model) { // Model é uma classe do spring 
	// o objeto recebido sera passado pelo spring para ser usado como modelo e preenchido com a lista de tarefas
		
		try {
			//TarefaDao dao = new TarefaDao();
			// Spring encapsula os dados da lista para exibicao no jsp 
			model.addAttribute("tarefas", dao.lista()); // objeto sera disponibilizado para lista.jsp
			return "tarefa/lista"; // redireciona web-inf/views/tarefa/lista.jsp
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	
	}
	
	// remove tarefa, objeto tarefa recebido vem de lista.jsp
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		try {
			//TarefaDao dao = new TarefaDao();
			dao.remove(tarefa);
			return "redirect:listaTarefas"; // chama metodo acima
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	// id recebido vem de lista.jsp
	// model é um modelo passado pelo spring, contera a tarefa buscada por id
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		try {
			//TarefaDao dao = new	TarefaDao();
			model.addAttribute("tarefa", dao.buscaPorId(id)); // busca tarefa por id, seta atributo que sera usado em mostra.jsp
			return "tarefa/mostra"; // chama mostra.jsp 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	// sera chamado por mostra.jsp
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		try {
			//TarefaDao dao = new TarefaDao();
			dao.altera(tarefa);
			return "redirect:listaTarefas"; // chama metodo acima
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
