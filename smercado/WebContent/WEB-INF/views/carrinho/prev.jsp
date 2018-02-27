<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/smercado/carrinhoF/" method="post">

		<table border=1>
			<tr>
				<th>Nome</th>
				<th>Tipo</th>
				<th>Preço</th>
				<th>Quantidade</th>
			</tr>

			<tr>
				<td>${produto.nome}</td>
				<td>${produto.tipo}</td>
				<td>R$ ${produto.preco}</td>
				<td><input type="number" name="qCompra" min="1"
					max="${produto.quantidade}"></td>
				<div>
					<input type="hidden" name="id" value="${produto.id }">
				</div>

			</tr>
		</table>
		<br>
		<button type="submit">Adicionar ao carrinho!</button>
	</form>

</body>
</html>