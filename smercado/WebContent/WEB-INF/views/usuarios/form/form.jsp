<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">

<style>
#t {
	padding-left: 4%;
}
</style>

</head>
<body>
	<c:import url="../../../imports/header.jsp">

	</c:import>

	<nav> <c:import url="../../../imports/menu.jsp"></c:import> </nav>

	<c:if test="${not empty loginLista}">
		<div id="t">
			<h2><%=session.getAttribute("loginLista")%></h2>
			<br>
		</div>
	</c:if>
	<form class="pure-form pure-form-aligned"
		action="/smercado/dados/cadastro" method="post">
		<fieldset>
			<div class="pure-control-group">
				<label for="name">Nome: </label> <input name="nome" type="text"
					placeholder="Coloque seu nome..." required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-control-group">
				<label for="name">CPF</label> <input name="cpf" type="text"
					placeholder="Coloque seu cpf..." required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-control-group">
				<label for="name">Email</label> <input name="email" type="text"
					placeholder="Coloque seu email..." required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-control-group">
				<label for="name">Senha</label> <input name="senha" type="password"
					placeholder="Coloque sua senha..." required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-control-group">
				<label for="name">Telefone</label> <input name="telefone"
					type="text" placeholder="Coloque sua senha..." required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>
			<div class="pure-control-group">
				<label for="name">Data de Nascimento</label> <input
					name="dataNascimento" type="text"
					placeholder="Coloque sua data de nascimento..." required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>

			<div class="pure-controls">

				<button type="submit" class="pure-button pure-button-primary">Submit</button>
			</div>
		</fieldset>
	</form>

	<footer> <c:import url="../../../imports/footer.jsp"></c:import>
	</footer>
</body>
</html>