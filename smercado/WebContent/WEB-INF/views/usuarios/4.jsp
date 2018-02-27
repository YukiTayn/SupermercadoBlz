<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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


	<div class="tab">
		<button class="tablinks" onclick="abrirAba(event, 'Vendas')">Vendas
			totais</button>
		<button class="tablinks" onclick="abrirAba(event, 'Cadastro')">Cadastro</button>
	</div>


	<div id="Vendas" class="tabcontent">

		<table border="1">
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

		<form action="/smercado/dados/cadastro" method="post">


			<div>
				<label>Nome: </label> <input type="text" name="nome" />
			</div>
			<div>
				<label>CPF: </label> <input type="text" name="cpf" />
			</div>
			<div>
				<label>Email: </label> <input type="text" name="email" />
			</div>
			<div>
				<label>Senha: </label> <input type="password" name="senha" />
			</div>
			<div>
				<label>Telefone: </label> <input type="text" name="telefone" />
			</div>
			<div>
				<label>Data de Nascimento: </label> <input type="text"
					name="dataNascimento" />
			</div>
			<div>
				<label> Cargo: </label> <select name="tipo">
					<option value="3">Gerente</option>
					<option value="4">Administrador</option>
				</select>
			</div>
			<div>
				<button type="submit">Adicionar</button>
			</div>
		</form>

	</div>


	<a href="/smercado/dados/alterar?id=<%=session.getAttribute("id")%>">Alterar</a>
	<br>
	<a href="/smercado/dados/apagar">Apagar</a>



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