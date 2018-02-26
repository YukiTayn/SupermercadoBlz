<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorate="~{layout}">
<head>
<title>Bem vindo ao sistema!</title>
</head>

<body>
	Hey

	<ol>
		<li><a href="dados/login">Login</a></li>
		<li><a href="painel">Painel</a></li>
		<li><a href="car">Carrinho</a></li>
		<li><a href="logout">Logout</a></li>
	</ol>

	<dl>			
		<dt>Dados</dt>
			<dd><a href="dados/listar">Lista de dados</a></dd>
			<dd><a href="dados/cadastro">Cliente</a></dd>
		<dt>Entregas</dt>
			<dd><a href="entregas/lista">Lista de entregas</a></dd>
			<dd><a href="entregas/nova">Nova entrega</a></dd>
		<dt>Produtos</dt>
			<dd><a href="produtos">Lista de produtos</a></dd>
			<dd><a href="produtos/novo">Cadastro de produtos</a></dd>
			<dd><a href="#">:Pesquisa de produtos:</a></dd>
		<dt>Vendas</dt>
			<dd><a href="vendas/">Lista de vendas</a></dd>
	</dl>

</body>
</html>