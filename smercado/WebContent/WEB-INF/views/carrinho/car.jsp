<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Carrinho de compras</title>

<style>
.a1:link, .a1:visited {
	background-color: #626262;
	color: white;
	padding: 1%;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

.a1:hover, .a1:active {
	background-color: red;
}
</style>

</head>
<body>

	<header> <c:import url="../../imports/header.jsp">

	</c:import> </header>

	<nav> <c:import url="../../imports/menu.jsp"></c:import> </nav>
	<table class="w3-table-all w3-hoverable">
		<tr>
			<th>Índice</th>
			<th>Produto</th>
			<th>Quantidade</th>
			<th>Preço</th>
			<th>Retirar</th>
		</tr>


		<c:forEach var="lista" items="${carrinho}">
			<tr>
				<td>${lista.indice}</td>
				<td>${lista.produto}</td>
				<td>${lista.qCompra}</td>
				<td>${lista.total}</td>
				<td><a href="retirar?indice=${lista.indice}">Aqui</a></td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<br>
	<nav> <a class="a1" href="/smercado/concluir">Concluir compra</a>
	<a class="a1" href="/smercado/produtos">Comprar mais</a> <a class="a1"
		href="cancelar">Cancelar TODA a compra</a> <a class="a1"
		href="/smercado/">Voltar ao index</a> </nav>

	<footer> <c:import url="../../imports/footer.jsp"></c:import></footer>
</body>
</html>