<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de tarefas</title>
</head>
<body>
	
	<a href="novaTarefa">Criar nova tarefa</a> <%-- chama TarefasController --%>	
	<br/>
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa"> <%-- objeto setado em TarefasController.java --%>
			<tr>
			<td>${tarefa.id}</td>
			<td>${tarefa.descricao}</td>
			<c:if test="${tarefa.finalizado eq false}">
				<td>Não	finalizado</td>
			</c:if>
			<c:if test="${tarefa.finalizado	eq true}">
				<td>Finalizado</td>
			</c:if>
			
			<%-- chama removeTarefa em TarefasController, o Spring passa o objeto completo conforme id --%>
			<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
			
			<%-- chama mostraTarefa em TarefasController, o Spring passa o objeto completo conforme id --%>
			<td><a	href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>