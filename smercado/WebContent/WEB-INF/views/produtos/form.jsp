<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/smercado/produtos/novo" method="post">

Nome: <input type="text" name="nome"><br>
Tipo: <input type="text" name="tipo"><br>
Quantidade: <input type="number" name="quantidade"><br>
Pre�o: <input type="number" step="any" name="preco"><br>
Data de Validade: <input type="text" name="dataValidade"><br>

<p>
<input type="submit">
</form>

</body>
</html>