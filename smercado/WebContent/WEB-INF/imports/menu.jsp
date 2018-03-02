<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar {
	overflow: hidden;
	background-color: #333;
	font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.teste12 {
	float: left;
	overflow: hidden;
	padding-left: 3%;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown-content form:hover {
	background-color: #ddd;
	padding: 3%;
}

.dropdown-content label {
	font-family: inherit;
	font-size: 110%;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown1 {
	float: right;
	overflow: hidden;
	padding-right: 3%;
}

.dropdown1 .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.dropdown1:hover {
	background-color: red;
}

.dropdown1:hover .dropdown-content {
	display: block;
}
</style>
</head>
<body>
	<div class="navbar">
		<div class="teste12">
			<a href="/smercado">Início</a>
			<c:choose>
				<c:when test="${not empty cargo}">
					<a href="/smercado/painel">Painel</a>
				</c:when>
				<c:when test="${empty cargo}">
					<div class="dropdown">
						<button class="dropbtn">
							Algo <i class="fa fa-carrent-down"></i>
						</button>
						<div class="dropdown-content">
							<a href="/smercado/dados/login">Login</a>
							<a href="/smercado/dados/cadastro">Cadastro</a>
						</div>
					</div>	
				</c:when>
			</c:choose>

		</div>

		<div class="dropdown">
			<button class="dropbtn">
				Produtos <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content" >
				<form action="/smercado/produtos/pesquisa" method="POST">
					<label>Pesquisa: </label><input type=text
						placeholder="Nome do produto..." name=nome>&nbsp
					<button type=submit>Enviar</button>
				</form>
				<c:choose>
					<c:when test="${cargo == 'gerente'}">
						<a href="/smercado/produtos/novo">Cadastro de produtos</a>
					</c:when>
					<c:when test="${cargo == 'administrador'}">
						<a href="/smercado/produtos/novo">Cadastro de produtos</a>
					</c:when>
				</c:choose>
				<a href="/smercado/produtos">Lista de produtos</a>
			</div>
		</div>


		<div class="dropdown">
			<button class="dropbtn">
				Carrinho <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<c:if test="${not empty carrinho}">
					<a href="car">Acessar carrinho</a>
				</c:if>
				<a href="/smercado/produtos">Comprar produtos</a>
			</div>
		</div>


		<c:if test="${not empty email}">
			<div class="dropdown1">
				<button class="dropbtn">
					Dados <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="/smercado/dados/apagar">Apagar conta</a> 
					<a href="/smercado/dados/alterar?id=<%=session.getAttribute("id")%>">Alterar
				SEUS dados</a>
					<a href="/smercado/logout">Logout</a>
				</div>
			</div>
		</c:if>

		<c:if test="${cargo == 'administrador'}">
			<div class="dropdown">
				<button class="dropbtn">
					Gerenciamento <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="/smercado/dados/listar">Lista de dados</a>
					<a href="#">#2</a> 
					<a href="#">#3</a>
				</div>
			</div>
		</c:if>

		<c:if test="${cargo == 'gerente'}">
			<div class="dropdown">
				<button class="dropbtn">
					Vendas <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="/smercado/vendas/">Lista de vendas</a> <a href="#">Adicionar venda</a> <a
						href="#">#3</a>
				</div>
			</div>
		</c:if>

		<c:if test="${cargo == 'gerente'}">
			<div class="dropdown">
				<button class="dropbtn">
					Entregas <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="/smercado/entregas/lista">Lista de entregas</a>
				</div>
			</div>
		</c:if>
		<c:if test="${cargo == 'administrador'}">
			<div class="dropdown">
				<button class="dropbtn">
					Entregas <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="/smercado/entregas/lista">Lista de entregas</a>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>


