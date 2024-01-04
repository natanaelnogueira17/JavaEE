<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel= "stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Contato</h1>
	<form action="update" name="frmContato">
		<table>
			<tr>
				<td> <input type="text" name="id"  id="Caixa3" readonly="readonly" value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td> <input type="text" name="nome"  class="Caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td> <input type="text" name="fone"  class="Caixa2" value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td> <input type="text" name="email"  class="Caixa1" value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
		
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	
	</form>
	<script type="text/javascript" src="scripts/validador.js"></script>
</body>
</html>