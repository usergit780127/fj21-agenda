<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário login</title>
</head>
<body>
	<h2>Página de Login das Tarefas</h2>
	<form action="efetuaLogin" method="post"> <%-- chama LoginController passando usuario que sera montado pelo spring --%>
		Login: <input type="text" name="login" /> <br /> <%-- name com mesmos nomes atributos classe Usuario --%>
		Senha: <input type="password" name="senha" /> <br />
		<input type="submit" value="Logar" />
	</form>

</body>
</html>