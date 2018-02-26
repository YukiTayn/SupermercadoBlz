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
	<h1>Carrinho</h1>

	<table border=1>

		<tr>
			<th>Índice</th>
			<th>Produto</th>
			<th>Quantidade</th>
			<th>Preço</th>
			<th>Subtotal</th>
			<th>Retirar</th>
		</tr>


		<c:forEach var="lista" items="${carrinho}">
			<tr>
				<td>${lista.indice}</td>
				<td>${lista.produto}</td>
				<td>${lista.quantidade}</td>
				<td>${lista.preco}</td>
				<td>${lista.total}</td>
				<td><a href="retirar?indice=${lista.indice}">Aqui</a></td>
			</tr>
		</c:forEach>
	</table>

<br><br>
<a href="/smercado/concluir">Concluir compra</a><br>
<a href="/smercado/produtos">Comprar mais</a><br>
<a href="cancelar">Cancelar TODA a compra</a><br>
<a href="/smercado/">Voltar ao index</a>
</body>
</html>