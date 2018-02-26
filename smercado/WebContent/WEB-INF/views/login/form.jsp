<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/smercado/login" method="post">

		Email: <input type="text" name="email"><br> Senha: <input
			type="password" name="senha"><br>
		<p>
			<input type="submit">
	</form>

	<h2>Lista de contas</h2>

	<table border="1">
		<tr>
			
			<th>Nome</th>
			<th>Email</th>
			<th>Senha</th>
			
		</tr>
		<c:forEach var="contas" items="${contas}">
			<tr>
				<td>${contas.nome }</td>
				<td>${contas.email }</td>
				<td>${contas.senha }</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>