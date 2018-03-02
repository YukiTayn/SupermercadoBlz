<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="name">Usuário</label> <input name="example" type="text"
					value="Nome" required> <span
					class="pure-form-message-inline">Campo necessário</span>
			</div>

			<div class="pure-control-group">
				<label for="password">Password</label> <input id="password"
					type="password" placeholder="Password">
			</div>

			<div class="pure-control-group">
				<label for="email">Email Address</label> <input id="email"
					type="email" placeholder="Email Address">
			</div>

			<div class="pure-control-group">
				<label for="foo">Supercalifragilistic Label</label> <input id="foo"
					type="text" placeholder="Enter something here...">
			</div>

			<div class="pure-controls">
				<label for="cb" class="pure-checkbox"> <input id="cb"
					type="checkbox"> I've read the terms and conditions
				</label>

				<button type="submit" class="pure-button pure-button-primary">Submit</button>
			</div>
		</fieldset>
	</form>

</body>
</html>