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
	</div>

	<div id="PedidosA" class="tabcontent">

		<table border="1">
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
					<td><a href="e?act=Cancelar&id=${abertas.id}">Cancelar</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<div id="PedidosP" class="tabcontent">
		<table border=1>

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
					<td><a href="e?act=Fechar&id=${pegas.id}">Fechar</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="PedidosC" class="tabcontent">

		<table border="1">
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

		<table border="1">
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

		<form action="e" method="post">
			<div>
				<label>Gerente: </label><input type="text" name="gerente"> <label>Entregador:
				</label><input type="text" name="ent">
			</div>
			<div>
				<label>Produto: </label><input type="text" name="prod"> <label>Quantidade:
				</label><input type="text" name="qtd">
			</div>
			<div>
				<button type="submit">Nova</button>
				<input type="hidden" name="act" value="Nova">
			</div>
		</form>

	</div>



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