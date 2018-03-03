<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de vendas</title>
</head>
<body>

	<header> <c:import url="../../imports/header.jsp">

	</c:import> </header>

	<nav> <c:import url="../../imports/menu.jsp"></c:import> </nav>
	<div class="w3-container">
		<h2>Lista de vendas</h2>

		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>ID</th>
				<th>Usuário</th>
				<th>Vendedor</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Valor</th>
				<th>Data da Venda</th>
			</tr>

			<c:forEach var="vendas" items="${vendas}">
				<tr>
					<td>${vendas.id}</td>
					<td>${vendas.userTXT}</td>
					<td>${vendas.vendTXT}</td>
					<td>${vendas.prodTXT}</td>
					<td>${vendas.qtd}</td>
					<td>RS ${vendas.valor}</td>
					<td><fmt:formatDate value="${vendas.dataVenda.time}"
							pattern="dd/MM/yyyy" /></td>

				</tr>
			</c:forEach>
		</table>
	</div>

	<footer> <c:import url="../../imports/footer.jsp"></c:import></footer>
</body>
</html>