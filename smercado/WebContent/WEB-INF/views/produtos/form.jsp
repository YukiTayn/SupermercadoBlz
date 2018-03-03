<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário de produto</title>
</head>
<body>

	<header> <c:import url="../../imports/header.jsp">

	</c:import> </header>

	<nav> <c:import url="../../imports/menu.jsp"></c:import> </nav>
	<form class="pure-form pure-form-aligned"
		action="/smercado/produtos/novo" method="post">
		<fieldset>
			<div class="pure-control-group">
				<label for="name">Nome: </label> <input name="nome" type="text"
					placeholder="Nome do produto..." required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-control-group">
				<label for="name">Tipo: </label> <input name="tipo" type="text"
					placeholder="Tipo do produto..." required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-control-group">
				<label for="name">Quantidade: </label> <input name="quantidade"
					type="text" placeholder="Quantidade do produto..." required>
				<span class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-control-group">
				<label for="name">Preço: </label> <input name="preco" type="text"
					placeholder="(Apenas números)" required>
				<span class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-control-group">
				<label for="name">Data de Validade: </label> <input
					name="dataValidade" type="text"
					placeholder="Dia/Mês/Ano" required>
				<span class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-controls">

				<button type="submit" class="pure-button pure-button-primary">Submit</button>
			</div>
		</fieldset>
	</form>

	<footer> <c:import url="../../imports/footer.jsp"></c:import></footer>
</body>
</html>