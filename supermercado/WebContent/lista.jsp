<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Lista de Produtos</h1>

	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Marca</th>
			<th>Tipo</th>
			<th>Quantidade</th>
			<th>Alterar</th>
			<th>Remover</th>
		</tr>
		
		<c:forEach var="produtos" items="${produtos}">
			<tr>
				<td>${produtos.nome}</td>
				<td>${produtos.marca}</td>
				<td>${produtos.tipo}</td>
				<td>${produtos.quantidade}</td>
				<td><a href="supermercado?logica=SelecionarProduto&id=${produtos.id}">Alterar</a></td>
				<td><a href="supermercado?logica=RemoverProduto&id=${produtos.id}">Remover</a></td>
			</tr>
		</c:forEach>
			
	</table>

</body>
</html>