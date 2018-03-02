<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
</head>
<body>

	<form action="/smercado/entregas/nova" method="post">
		<div>
			<label>Entregador: </label> <input type="text" name="entregador" />
		</div>
		<div>
			<label>Produto: </label> <input type="text" name="produto" />
		</div>
		<div>
			<label>Quantidade: </label> <input type="text" name="qtd" />
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>

	<form class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="name">Usuário</label> <input name="" type="text"
					placeholder="" required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>
			
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Submit</button>
			</div>
		</fieldset>
	</form>

</body>
</html>