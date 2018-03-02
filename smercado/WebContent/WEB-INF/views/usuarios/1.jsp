<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
		<button class="tablinks" onclick="abrirAba(event, 'ComprasF')">Compras
			físicas</button>
		<button class="tablinks" onclick="abrirAba(event, 'ComprasO')">Compras
			online</button>
	</div>

	<div id="ComprasF" class="tabcontent">
		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>ID</th>
				<th>Vendedor</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>

			<c:forEach var="compras" items="${compras}">
				<tr>
					<td>${compras.id}</td>
					<td>${compras.vendTXT}</td>
					<td>${compras.prodTXT}</td>
					<td>${compras.qtd}</td>
					<td>${compras.valor}</td>
					<td><fmt:formatDate value="${compras.dataVenda.time}"
							pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="ComprasO" class="tabcontent">
		<table class="w3-table-all w3-hoverable">

			<tr>
				<th>ID</th>
				<th>Vendedor</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>
			<c:forEach var="comprasOn" items="${comprasOn}">
				<tr>
					<td>${comprasOn.id}</td>
					<td>#Online#</td>
					<td>${comprasOn.prodTXT}</td>
					<td>${comprasOn.qtd}</td>
					<td>${comprasOn.valor}</td>
					<td><fmt:formatDate value="${comprasOn.dataVenda.time}"
							pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
		</table>


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