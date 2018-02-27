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

	<h1>Lista de Produtos</h1>

	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Tipo</th>
			<th>Quantidade</th>
			<th>Preço</th>
			<th>Comprar</th>
		</tr>

		<c:forEach var="prod" items="${prod}">
			<tr>
				<td>${prod.nome}</td>
				<td>${prod.tipo}</td>
				<td>${prod.quantidade}</td>
				<td>${prod.preco}</td>
				<td><a href="/smercado/add?id=${prod.id}">Comprar</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>