<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página para edição de tarefas</title>
</head>
<body>
	<%-- sera chamada por TarefasController mostraTarefa --%>
	<h1>Página para edição de tarefas</h1>
	<h3>Alterar	tarefa - ${tarefa.id}</h3> <%-- atributo setado em TarefasController mostraTarefa --%>

	<form action="alteraTarefa" method="post"> <%-- chama alteraTarefa em TarefasController --%>
		<%-- campos aparecem setados na tela, name iguais atributos na classe Tarefa --%>
		<input type="hidden" name="id" value="${tarefa.id}"	/>
		Descrição:<br/>
		<textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
		<br/>
																			<%-- finalizado aparece marcado ou vazio --%>
		Finalizado?	<input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : ''}/><br/>
		<input type="submit" value="Alterar"/>
	</form>

</body>
</html>

<%-- Descrição de como trabalhar com data, nao foi usado nos exercicios:

- Para o Spring MVC saber converter automaticamente a data no formato brasileiro para um
Calendar é preciso usar a anotação @DateTimeFormat.
- Na classe Tarefa, colocar a anotacao no atributo:
@DateTimeFormat(pattern="dd/MM/yyyy")
private Calendar dataFinalizacao;

- Para mostrar a data na pagina jsp:
<input type="text" name="dataFinalizacao"
 value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" 
 pattern="dd/MM/yyyy"/>"
 />	

--%>