<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%-- taglib usada para exibir mensagens de validacao --%>
<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario adicionar tarefas</title>

</head>
<body>
	<h3>Adicionar tarefas</h3>
	
	<form:errors path="tarefa.descricao" cssStyle="color:red"/> <%-- mensagem de validacao atributo descricao classe Tarefa --%>
			
	<form action="adicionaTarefa" method="post"> <%-- chama TarefasController --%>
		Descrição: <br/>
		<textarea name="descricao" rows="5" cols="100"></textarea> <%-- name descricao igual atributo classe Tarefa --%>
		<br/> 
		
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>