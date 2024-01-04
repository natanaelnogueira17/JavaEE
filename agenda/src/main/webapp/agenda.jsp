<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "model.JavaBeans" %>

<%@ page import = "java.util.List" %>
<%
	@SuppressWarnings("unchecked")
	List<JavaBeans> list = (List<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel= "stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="Botao1" >Novo Contato</a>
	<a href="report" class="Botao1" >Relatório</a>
	<table id="tabela">
		<thead>			
			  <tr>
			    <th>ID</th>
			    <th>Nome</th>
			    <th>Fone</th>
			    <th>Email</th>
			    <th>Opções</th>
			  </tr>

		</thead>
		<tbody>
			<%for(JavaBeans contato : list){ %>
				<tr>
					<td><%= contato.getId()%></td>
					<td><%= contato.getNome()%></td>
					<td><%= contato.getFone()%></td>
					<td><%= contato.getEmail()%></td>
					<td>
						<a href="select?id=<%= contato.getId()%>" class=" Botao1">Editar</a>
						<a href="javascript:confirmar(<%= contato.getId()%>)" class=" Botao2">Excluir</a>
					</td>
				</tr>
			<%} %>
		
		</tbody>
	</table>
	<script type="text/javascript" src="scripts/confirmador.js"></script>
</body>
</html>