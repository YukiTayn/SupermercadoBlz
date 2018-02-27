<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/smercado/dados/cadastro" method="post">
	
		<div>
			<select name="tipo">
				<option value=1>Cliente</option>
				<option value=2>Vendedor</option>
				<option value=5>Entregador</option>
				<option value=4>Gerente</option>
				<option value=3>Administrador</option>
			</select>
		</div>
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
			<button type="submit">Adicionar</button>
		</div>
	</form>

</body>
</html>