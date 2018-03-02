<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header> <c:import url="../../imports/header.jsp">

	</c:import> </header>

	<nav> <c:import url="../../imports/menu.jsp"></c:import> </nav>
	<form class="pure-form pure-form-aligned" action="/smercado/carrinho/"
		method="post">

		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>Nome</th>
				<th>Tipo</th>
				<th>Preço</th>
				<th>Quantidade</th>
			</tr>

			<tr>
				<td>${produto.nome}</td>
				<td>${produto.tipo}</td>
				<td>R$ ${produto.preco}</td>
				<td><input name="qCompra" type="number" required></td>
				<div>
					<input type="hidden" name="id" value="${produto.id }">
				</div>

			</tr>
		</table>
		<br>
		<button type="submit">Adicionar ao carrinho!</button>
	</form>

	<footer> <c:import url="../../imports/footer.jsp"></c:import></footer>
</body>
</html>