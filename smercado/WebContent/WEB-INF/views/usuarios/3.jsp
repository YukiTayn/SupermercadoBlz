<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">

<title>Insert title here</title>
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
		<button class="tablinks" onclick="abrirAba(event, 'PedidosA')">Pedidos
			abertos</button>
		<button class="tablinks" onclick="abrirAba(event, 'PedidosP')">Pedidos
			pegos</button>
		<button class="tablinks" onclick="abrirAba(event, 'PedidosC')">Pedidos
			concluídos</button>
		<button class="tablinks" onclick="abrirAba(event, 'PedidosN')">Pedidos
			negados</button>
		<button class="tablinks" onclick="abrirAba(event, 'Fazer')">Fazer
			pedido</button>
		<button class="tablinks" onclick="abrirAba(event, 'Cadastro')">Cadastro</button>
	</div>

	<div id="PedidosA" class="tabcontent">

		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>ID</th>
				<th>Entregador</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Data</th>
				<th>Ação</th>
			</tr>

			<c:forEach var="abertas" items="${abertas}">
				<tr>
					<td>${abertas.id}</td>
					<td>${abertas.enttxt}</td>
					<td>${abertas.produtotxt}</td>
					<td>${abertas.qtd}</td>
					<td><fmt:formatDate value="${abertas.dataPedido.time}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="/smercado/entregas/cancelar?id=${abertas.id}">Cancelar</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div id="PedidosP" class="tabcontent">
		<table class="w3-table-all w3-hoverable">

			<tr>
				<th>ID</th>
				<th>Entregador</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Data</th>
				<th>Ação</th>
			</tr>
			<c:forEach var="pegas" items="${pegas}">
				<tr>
					<td>${pegas.id}</td>
					<td>${pegas.enttxt}</td>
					<td>${pegas.produtotxt}</td>
					<td>${pegas.qtd}</td>
					<td><fmt:formatDate value="${pegas.dataPedido.time}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="/smercado/entregas/fechar?id=${pegas.id}">Fechar</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="PedidosC" class="tabcontent">

		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>ID</th>
				<th>Entregador</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Data</th>
				<th>Entrega</th>
			</tr>

			<c:forEach var="conc" items="${conc}">
				<tr>
					<td>${conc.id}</td>
					<td>${conc.enttxt}</td>
					<td>${conc.produtotxt}</td>
					<td>${conc.qtd}</td>
					<td><fmt:formatDate value="${conc.dataPedido.time}"
							pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${conc.dataEntrega.time}"
							pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div id="PedidosN" class="tabcontent">

		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>ID</th>
				<th>Entregador</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Data</th>
				<th>Entrega</th>
			</tr>

			<c:forEach var="neg" items="${neg}">
				<tr>
					<td>${neg.id}</td>
					<td>${neg.enttxt}</td>
					<td>${neg.produtotxt}</td>
					<td>${neg.qtd}</td>
					<td><fmt:formatDate value="${neg.dataPedido.time}"
							pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${neg.dataEntrega.time}"
							pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div id="Fazer" class="tabcontent">

		<form class="pure-form pure-form-aligned"
			action="/smercado/entregas/nova" method="post">
			<fieldset>
				<div class="pure-control-group">
					<label for="name">Entregador</label> <select name="entregador">
						<c:forEach var="ent" items="${ent}">
							<option value="${ent.id}">${ent.nome}</option>
						</c:forEach>
					</select> <span class="pure-form-message-inline">Campo necessário</span>
				</div>

				<div class="pure-control-group">
					<label for="name">Produto</label> <select name="produto">
						<c:forEach var="produtos" items="${produtos}">
							<option value="${produtos.id}">${produtos.nome}</option>
						</c:forEach>
					</select><span class="pure-form-message-inline">Campo necessário</span>
				</div>
				<div class="pure-control-group">
					<label for="name">Quantidade: </label> <input name="qtd"
						type="number" required> <span
						class="pure-form-message-inline">Campo necessário</span>
				</div>
				<div class="pure-controls">

					<button type="submit" class="pure-button pure-button-primary">Submit</button>
				</div>
			</fieldset>
		</form>

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
					<label for="name">Email</label> <input name="emai." type="text"
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
						<option value="2">Vendedor</option>
						<option value="5">Entregador</option>
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