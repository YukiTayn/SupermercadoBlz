<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
button {
	background: none !important;
	border: none;
	padding: 0 !important;
	/*optional*/
	font-family: arial, sans-serif; /*input has OS specific font-family*/
	color: #069;
	text-decoration: underline;
	cursor: pointer;
}
</style>

</head>
<body>
	<h1>Carrinho</h1>

	<table border=1>
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
	<a href="/smercado/produtosv">Adicionar mais produtos</a>
	<br>
	<a href="/smercado/concluirv">Concluir venda</a>
	<br>
	<a href="cancelar">Cancelar TODA a venda</a>
</body>
</html>