<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header> <c:import url="../../../imports/header.jsp">

	</c:import> </header>

	<nav> <c:import url="../../../imports/menu.jsp"></c:import> </nav>
	<h1>
		Obrigado pelo cadastro,
		<%=session.getAttribute("nomeC")%></h1>

	<h3>Você será redirecionado para a pagina inicial em 5 segundos...</h3>

	<footer> <c:import url="../../../imports/footer.jsp"></c:import></footer>
	<script>
		window.setTimeout("location.href='/smercado/'", 5000)
	</script>
</body>
</html>