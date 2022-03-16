<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8" />
<title>Person List</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<h1>Person List</h1>

	<br />
	<br />
	<a href="${pageContext.request.contextPath}/addPerson">Add Person</a>  
	<div>
		<table border="1">
			<tr>
				<th>No.</th>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${persons}" var="person" varStatus="loop">
				<tr>
					<td>${loop.count}</td>
					<td>${person.ID}</td>
					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
					<th><a href="editPerson?id=<c:out value='${person.ID}'/>">Edit</a></th>
					<th><a href="deletePerson?id=<c:out value='${person.ID}'/>">Delete</a></th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>