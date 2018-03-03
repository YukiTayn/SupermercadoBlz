<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">

<title>Painel - Administrador</title>
<style>
body {
	font-family: Arial;
}

/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}
</style>
</head>
<body>


	<header> <c:import url="../../imports/header.jsp">

	</c:import> </header>

	<nav> <c:import url="../../imports/menu.jsp"></c:import> </nav>

	<div class="tab">
		<button class="tablinks" onclick="abrirAba(event, 'Vendas')">Vendas
			totais</button>
		<button class="tablinks" onclick="abrirAba(event, 'Cadastro')">Cadastro</button>
	</div>


	<div id="Vendas" class="tabcontent">

		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>ID</th>
				<th>Vendedor</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>

			<c:forEach var="vendas" items="${vendas}">
				<tr>
					<td>${vendas.id}</td>
					<td>${vendas.vendTXT}</td>
					<td>${vendas.prodTXT}</td>
					<td>${vendas.qtd}</td>
					<td>${vendas.valor}</td>
					<td><fmt:formatDate value="${vendas.dataVenda.time}"
							pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div id="Cadastro" class="tabcontent">


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
						placeholder="Coloque sua data de nascimento..." required>
					<span class="pure-form-message-inline">Campo necessário</span>
				</div>
				<div class="pure-control-group">
					<label for="name">Cargo</label> <select name="tipo">
						<option value="3">Gerente</option>
						<option value="4">Administrador</option>
					</select> <span class="pure-form-message-inline">Campo necessário</span>
				</div>
				<div class="pure-controls">

					<button type="submit" class="pure-button pure-button-primary">Submit</button>
				</div>
			</fieldset>
		</form>

	</div>


	<footer> <c:import url="../../imports/footer.jsp">

	</c:import> </footer>
	<script>
		function abrirAba(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}
	</script>

</body>
</html>