package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // indica ao spring que os metodos da classe sao Action
public class OlaMundoController {

	@RequestMapping("/olaMundoSpring") // url que chamara o metodo
	public String execute() {
		System.out.println("Executando a lógica com Spring MVC"); // sera impresso no console
		return "ok"; // ok.jsp, pasta WEB-INF/views, arquivo que sera redirecionado
	}
	
	// varios metodos podem ser criados, cada um com seu @RequestMapping
	
}
