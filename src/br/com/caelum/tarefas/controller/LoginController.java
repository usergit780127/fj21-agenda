package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.UsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login"; // chama web-inf/views/formulario-login.jsp
	}
	
	// verifica a existencia de usuario
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) { // atributo sessao
		try {
			if (new UsuarioDao().existeUsuario(usuario)) { // pesquisa usuario
				session.setAttribute("usuarioLogado", usuario); // seta atributo
				return "menu"; // chama web-inf/views/menu.jsp
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// caso login e senha nao sejam encontrados
		return "redirect:loginForm"; // chama metodo acima
	}
	
	// faz logout
	@RequestMapping("logout")
	public String logout(HttpSession session) { // atributo sessao
		session.invalidate(); // remove usuario da sessao
		return "redirect:loginForm";// chama metodo acima
	}
	
}
