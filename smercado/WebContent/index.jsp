<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorate="~{layout}">
<head>
<title>Bem vindo ao sistema!</title>
<style>
.teste {
	border: 1px solid red;
	padding: 2%;
}

p {
	padding: 4%;
}
</style>
</head>

<body>

	<header>
		<c:import url="imports/header.jsp"></c:import>
	</header>

	<nav>
		<c:import url="imports/menu.jsp"></c:import>
	</nav>


	<c:if test="${not empty nome}">
		<div class="teste">
			<h2>
				Bem vindo,
				<%=session.getAttribute("nome")%></h2>

		</div>
	</c:if>

	<div class="teste">

		<p align="justify">Lorem ipsum dolor sit amet, consectetur
			adipiscing elit. Aliquam at rutrum tellus. Maecenas vel ligula
			dapibus, faucibus elit sed, luctus arcu. Maecenas rutrum nunc non
			nibh ultricies, ut rhoncus elit interdum. Aliquam laoreet, urna nec
			euismod pharetra, nunc sem maximus orci, vel aliquam nulla lorem in
			arcu. Nulla et ex sit amet massa convallis rutrum at id dolor.
			Integer interdum, neque et vestibulum hendrerit, sapien orci posuere
			mi, ac ultricies sem justo a libero. Vestibulum nec urna in erat
			volutpat egestas. Vestibulum velit felis, auctor at commodo sed,
			fermentum ac orci. Cras consectetur, quam ac sollicitudin volutpat,
			magna quam blandit mauris, sit amet rhoncus turpis ex eget turpis.
			Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
			posuere cubilia Curae; Integer vel luctus metus, eu hendrerit purus.
			In facilisis ullamcorper dolor, ac molestie orci pharetra a. Fusce
			quis lorem eget quam commodo suscipit. In dapibus vel sem sed
			pulvinar. Cras dictum tempus ultrices. Praesent vel consequat est, in
			dignissim neque. Aenean pulvinar volutpat augue quis posuere. Proin a
			lacus at risus porta cursus. Ut id quam sed turpis facilisis
			tincidunt et ut dui. Mauris suscipit velit sit amet ante fringilla,
			eu consequat ligula sollicitudin. Mauris id hendrerit orci. Proin
			eget iaculis tellus, eu tempus metus. Cras ut vehicula erat. Nunc
			diam lorem, luctus ac dignissim eget, tempor quis nisi. Pellentesque
			habitant morbi tristique senectus et netus et malesuada fames ac
			turpis egestas. Nunc sit amet rutrum massa. Cras placerat mi est, eu
			pretium lacus venenatis non. Nulla dapibus, enim et fringilla
			facilisis, ligula quam vestibulum velit, finibus porta nunc diam
			dictum justo. Maecenas blandit fermentum elit quis semper. Sed
			faucibus, lorem at tempor vulputate, tellus leo interdum ligula, vel
			suscipit felis nunc et neque. Phasellus nec nisl aliquam, commodo
			orci ac, consequat lorem. Cras et auctor nulla. Duis magna felis,
			consequat sit amet quam eget, rutrum egestas nibh. Donec non purus
			gravida, faucibus lectus eu, sollicitudin quam. Aenean porta in justo
			nec euismod. Nullam eu ante et lectus consectetur ornare. Nulla
			facilisi. Nullam quis facilisis sem, vitae laoreet lacus. Suspendisse
			pulvinar, diam sed gravida placerat, mi enim lobortis mi, in
			vestibulum est ipsum quis lorem. Proin eu tempus lorem. Cras sodales
			lorem ex, in viverra lorem efficitur pharetra. Sed turpis massa,
			commodo id nunc in, consectetur finibus elit. Mauris at nisl aliquam
			dui dictum lacinia. Ut facilisis, felis vel vehicula mattis, nisl
			nisl rhoncus tellus, vel luctus lacus libero eget nisl. Maecenas
			pretium elementum arcu a facilisis. Vestibulum posuere, ipsum ut
			commodo tristique, lacus diam rutrum justo, vel interdum nibh tortor
			ultrices purus. Proin lectus risus, facilisis suscipit semper
			lobortis, bibendum ut felis. Curabitur eget consectetur mi, a
			bibendum metus. In hac habitasse platea dictumst. Donec mi massa,
			suscipit et est consectetur, tincidunt feugiat lorem. Nulla pharetra
			enim purus, id venenatis lacus vulputate in. Praesent volutpat ante
			ligula, id lacinia nunc scelerisque vitae. Sed venenatis dictum metus
			at varius. Nunc malesuada, est vel auctor mattis, lectus quam
			lobortis justo, in sagittis elit mi eu sapien. Class aptent taciti
			sociosqu ad litora torquent per conubia nostra, per inceptos
			himenaeos. Morbi a felis non erat ornare luctus. Integer laoreet
			rhoncus magna, in sollicitudin neque rutrum ut. Pellentesque eleifend
			fermentum nisi eget tincidunt. Donec ut finibus elit. Ut pellentesque
			quis elit et consectetur. Nam leo dui, ornare et leo nec, semper
			ultrices leo. Integer finibus massa vitae scelerisque auctor.</p>

	</div>

	<footer>
		<c:import url="imports/footer.jsp"></c:import>
	</footer>


</body>
</html>