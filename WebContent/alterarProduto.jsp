<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Alterar contato</h2>

	<form action="supermercado" method="post">
		<div>
			<input type="hidden" name="id" value="${produto.id}" />
		</div>
		<div>
			<label>Nome: </label> <input type="text" name="nome"
				value="${produto.nome}" />
		</div>
		<div>
			<label>Marca: </label> <input type="text" name="marca"
				value="${produto.marca}" />
		</div>
		<div>
			<label>Tipo: </label> <input type="text" name="tipo"
				value="${produto.tipo}" />
		</div>
		<div>
			<label>Quantidade: </label> <input type="text" name="quantidade"
				value="${produto.quantidade}" />
		</div>
		<div>
			<button type="submit">Alterar</button>
			<input type="hidden" name="logica" value="AlterarProduto">
		</div>
	</form>
</body>
</html>