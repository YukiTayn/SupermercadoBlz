<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Contato</title>
</head>
<body>
<h2>Alterar Contato</h2>
<form action="mvc" method = "post" >
		<div>
			<label>Nome: </label>
			<input type="text" name="nome" value="${contato.nome}" readonly="readonly"/>
		</div>
		<br>
		<div>
			<label>Email: </label>
			<input type="text" name="email" value="${contato.email }" />
		</div>
		<br>
		<div>
			<label>Endereço: </label>
			<input type="text" name="endereco" value="${contato.endereco }" />
		</div>
		<br>
		<div>
			<label>Data de Nascimento: </label>
			<input type="text" name="dataNascimento" value=<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>/>
			
		</div>
		<br>
		<div>
			<button type="submit">Alterar</button>
			<input  type="hidden" name= "logica" value= "AlterarContato">
		</div>
	</form>
</body>
</html>