<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro</title>

<style type="text/css">
#t {
	padding: 4%;
}
</style>
</head>
<body>

	<header> <c:import url="../../imports/header.jsp">

	</c:import> </header>

	<nav> <c:import url="../../imports/menu.jsp"></c:import> </nav>

	<div id="t">
		<h1>Aconteceu algum erro</h1>

		<h3>Você será redirecionado para a página inicial em 5
			segundos...</h3>
	</div>

	<footer> <c:import url="../../imports/footer.jsp"></c:import></footer>

	<script>
		window.setTimeout("location.href='/smercado/'", 5000)
	</script>
</body>
</html>