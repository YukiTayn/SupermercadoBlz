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
		</tr>

		<c:forEach var="pesq" items="${pesq}">
			<tr>
				<td>${pesq.nome}</td>
				<td>${pesq.tipo}</td>
				<td>${pesq.quantidade}</td>
				<td>${pesq.preco}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>