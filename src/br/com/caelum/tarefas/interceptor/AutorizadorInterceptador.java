package br.com.caelum.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// classe para interceptar usuarios e nao permitir acesso sem login
// deve ser registrado no spring-context
public class AutorizadorInterceptador extends HandlerInterceptorAdapter{
	
	// implementacao metodo preHandle HandlerInterceptorAdapter
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		
		String uri = request.getRequestURI(); // captura barra endereco
		
		// se terminar em loginForm, efetuaLogin ou pasta resources permite continuar aplicacao sem estar logado
		if (uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources")) {
			return true;
		}
		if (request.getSession().getAttribute("usuarioLogado") != null) { // atributo setado em LoginController
			return true; // se usuario estiver logado na sessao permite continuar aplicacao
		}
		response.sendRedirect("loginForm"); // se nao estiver logado na sessao redireciona fluxo para LoginController
		return false;
	}
	
	

}
