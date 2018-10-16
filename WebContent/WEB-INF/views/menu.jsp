<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<h2>Página	inicial	da	Lista	de	Tarefas</h2>
	<p>Bem vindo, ${usuarioLogado.login}</p> <%-- atributo setado em LoginController --%>
	<a href="listaTarefas">Clique aqui</a> para acessar a lista de tarefas <%-- chama TarefasController --%>
	<br/>
	<a href="logout">Sair do sistema</a> <%-- chama LoginController --%>

</body>
</html>