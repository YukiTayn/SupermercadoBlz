<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header> <c:import url="../../imports/header.jsp">

	</c:import> </header>

	<nav> <c:import url="../../imports/menu.jsp"></c:import> </nav>

	<form class="pure-form pure-form-aligned" action="/smercado/cVendedor"
		method="post">
		<fieldset>
			<div class="pure-control-group">
				<label for="name">Email do Cliente: </label> <input id="eCliente"
					type="text" placeholder="Usuário" required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>

			<input type="hidden" value="${vendas.produto}" name="produto"><br>
			<input type="hidden" value="${vendas.qtd}" name="qtd"><br>
			<input type="hidden" value="${vendas.valor}" name="valor"><br>
			<input type="hidden" value="${vendas.vendedor}" name="vendedor"><br>

			<button type="submit" class="pure-button pure-button-primary">Submit</button>
		</fieldset>
	</form>

	<footer> <c:import url="../../imports/footer.jsp"></c:import></footer>
</body>
</html>