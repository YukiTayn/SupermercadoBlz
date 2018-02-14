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
	<table border="1">
			<tr>
				<th>ID</th>
				<th>Gerente</th>
				<th>Entregador</th>
				<th>Produto</th>
				<th>Quantidade</th>
			</tr>

			<c:forEach var="lista" items="${lista}">
				<tr>
					<td>${lista.id}</td>
					<td>${lista.gerente}</td>
					<td>${lista.entregador}</td>
					<td>${lista.produto}</td>
					<td>${lista.qtd}</td>
					
				</tr>
			</c:forEach>
		</table>
</body>
</html>