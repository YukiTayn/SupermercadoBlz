<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionando Atendentes</title>
</head>
<body>
<form action="AdicionarAtendente" method = "post" >
		<div>
			<label>Nome: </label>
			<input type="text" name="nome" />
		</div>
		<br>
		<div>
			<label>idade: </label>
			<input type="text" name="nome" />
		</div>
		<br>
		<div>
			<label>cpf: </label>
			<input type="text" name="nome" />
		</div>
		<br>
		
		<div>
			<label>Endereço: </label>
			<input type="text" name="endereco" />
		</div>
		<br>
		<div>
			<label>Email: </label>
			<input type="text" name="email" />
		</div>
		<br>
		<div>
			<button type="submit">Adicionar</button>
			
		</div>
	</form>
</body>
</html>