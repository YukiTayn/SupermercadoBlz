<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

	<div class="w3-container">
		<h2>Striped Bordered Table</h2>

		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Points</th>
				<c:if test="${cargo == 'cliente'}">
					<th>Teste1</th>
					<th>Teste2</th>
				</c:if>

			</tr>
			<tr>
				<td>Jill</td>
				<td>Smith</td>
				<td>50</td>
				<c:if test="${cargo == 'cliente'}">
					<td>1</td>
					<td>2</td>
				</c:if>
			</tr>
			<tr>
				<td>Eve</td>
				<td>Jackson</td>
				<td>94</td>
				<c:if test="${cargo == 'cliente'}">
					<td>1</td>
					<td>2</td>
				</c:if>
			</tr>
			<tr>
				<td>Adam</td>
				<td>Johnson</td>
				<td>67</td>
				<c:if test="${cargo == 'cliente'}">
					<td>1</td>
					<td>2</td>
				</c:if>
			</tr>
		</table>
	</div>

</body>
</html>
