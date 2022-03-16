<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>

	<div align="center">
		<h1>List Of Student</h1>
		<a href="${pageContext.request.contextPath}/addStudent">Add New Student</a>
		<table border="1">
			<tr>
				<th>No.</th>
				<th>Code</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Birthday</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			 <c:forEach items="${students}" var="student" varStatus="loop">
				<tr align="center">
					<td>${loop.count}</td>
					<td>${student.code}</td>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.gender}</td>
					<td>${student.email}</td>
					<td>${student.birthday}</td>
					<th><a href="editStudent?id=<c:out value='${student.id}'/>">Edit</a></th>
					<th><a href="deleteStudent?id=<c:out value='${student.id}'/>">Delete</a></th>
				</tr>
			</c:forEach> 
		</table> 
	</div>
</body>
</html>