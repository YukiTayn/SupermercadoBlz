<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<style>

	h3{
		padding-left: 10%;
	}

</style>
</head>
<body>

	<c:import url="../../../imports/header.jsp">

	</c:import>

	<nav> <c:import url="../../imports/menu.jsp"></c:import> </nav>


	<br>
	
	<c:if test="${not empty mensagem }">
		<h3><%= session.getAttribute("mensagem") %></h3>
		<br>
	</c:if>
	
	<form class="pure-form pure-form-aligned" action="/smercado/login"
		method="post">
		<fieldset>
			<div class="pure-control-group">
				<label>Usuário</label> <input name="email" type="text"
					placeholder="Email..." required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>

			<div class="pure-control-group">
				<label for="password">Password</label> <input name="senha"
					type="password" placeholder="Password">
			</div>

			<div class="pure-controls">

				<button type="submit" class="pure-button pure-button-primary">Submit</button>
			</div>
		</fieldset>
	</form>

	<footer> <c:import url="../../imports/footer.jsp"></c:import></footer>
</body>
</html>