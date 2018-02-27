<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Obrigado pelo cadastro,
		<%=session.getAttribute("nome")%></h1>
		
	<h3>Você será redirecionado para a pagina inicial em 5 segundos...</h3>	


	<script>
		window.setTimeout("location.href='/smercado/'", 5000)
	</script>
</body>
</html>