<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisa de produto(s)</title>
</head>
<body>

	<header> <c:import url="../../imports/header.jsp">

	</c:import> </header>

	<nav> <c:import url="../../imports/menu.jsp"></c:import> </nav>
	<div class="w3-container">
		<h2>Pesquisa: </h2>

		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>Nome</th>
				<th>Tipo</th>
				<th>Quantidade</th>
				<th>Preço</th>
				<c:choose>
					<c:when test="${cargo == 'vendedor'}">
						<th>Vender</th>
					</c:when>
					<c:when test="${cargo == 'administrador'}">
						<th>Remover</th>
						<th>Comprar</th>
					</c:when>
					<c:otherwise>
						<th>Comprar</th>
					</c:otherwise>
				</c:choose>
			</tr>

			<c:forEach var="pesq" items="${pesq}">
				<tr>
					<td>${pesq.nome}</td>
					<td>${pesq.tipo}</td>
					<td>${pesq.quantidade}</td>
					<td>${pesq.preco}</td>
					<c:if test="${cargo == 'gerente'}">
						<td><a href="/smercado/produtos/remover?id=${pesq.id}">Remover</a></td>
					</c:if>
					<c:if test="${cargo == 'administrador'}">
						<td><a href="/smercado/produtos/remover?id=${pesq.id}">Remover</a></td>
					</c:if>
					<c:choose>
						<c:when test="${cargo == 'vendedor'}">
							<td><a href="/smercado/add?id=${pesq.id}">Vender</a></td>
						</c:when>
						<c:otherwise>
							<td><a href="/smercado/add?id=${pesq.id}">Comprar</a></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div>
	<footer> <c:import url="../../imports/footer.jsp"></c:import>
</body>
</html>