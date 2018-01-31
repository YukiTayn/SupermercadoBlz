<%@page import="supermercado.models.*"%>
<%@page import="java.util.List"%>
<%@page import="supermercado.daos.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />


	<h1>Lista de atendentes</h1>

	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Idade</th>
			<th>Cpf</th>
			<th>Endereço</th>
			<th>Email</th>
			<th>Remover</th>
			<th>Alterar</th>
		</tr>

		<c:forEach var="atendente" items="${atendente}">

			<tr>
				<td>${atendente.nome}</td>
				<td>${atendente.idade }</td>
				<td>${atendente.cpf}</td>
				<td>${atendente.endereco}</td>	
				<td>${atendente.email}</td>
				
				
				
				<td><a href= "supermercado?logica=RemoverAtendente&cpf=${atendente.cpf}"> Remover </a></td>	
				<td><a href= "supermercado?logica=SelecionarAtendente&cpf=${atendente.cpf}"> Alterar </a></td>		
			</tr>
		</c:forEach>


		<!--
		<c:forEach var="atendente" items="${dao.lista}">
			<tr>
				<td><a href="mvc?logica=RemoveAtendenteLogic&cpf=${atendente.cpf}">Remover</a>
				</td>
			</tr>
		</c:forEach> -->


	</table>
	<c:import url="rodape.jsp" />
</body>
</html>