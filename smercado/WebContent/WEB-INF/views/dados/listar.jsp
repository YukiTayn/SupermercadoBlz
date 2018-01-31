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
	<h1>Lista de Dados</h1>

	<table border="1">
		<tr>
			<th>Tipo</th>
			<th>Nome</th>
			<th>Email</th>
			<th>CPF</th>
			<th>Telefone</th>
			<th>Data de Nascimento</th>
		</tr>

		<c:forEach var="dados" items="${dados}">
			<tr>
				<td>${dados.tipo}</td>
				<td>${dados.nome}</td>
				<td>${dados.email}</td>
				<td>${dados.cpf}</td>
				<td>${dados.telefone}</td>
				<td><fmt:formatDate value="${dados.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>