<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en"
	xmlns:th="http://www.springframework.org/schema/data/jaxb">
<head>
<meta charset="ISO-8859-1">
<title>Student Update</title>
</head>
<body>
	<div align="center">
		<h1>Edit Student Info</h1>

		<form th:object="${student}" th:action="@{save}" action="editStudentSave"
			modelAttribute="student" method="post">
 			<div>  
                <input type="hidden" th:field="*{id}" class="form-control"  name="id" placeholder="id" value="${student.id}"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>
			<div>
				<label th:text="Code" th:for="Code"></label> <input
					type="text" th:field="Code" name="code"
					placeholder="Code" value="${student.code}" />
			</div>
			<div style="clear: both; display: block; height: 10px"></div>
			<div>
				<label th:text="FirstName" th:for="FirstName"></label> <input
					type="text" th:field="*{FirstName}" name="firstName"
					placeholder="First Name" value="${student.firstName}" />
			</div>
			<div style="clear: both; display: block; height: 10px"></div>
			<div>
				<label th:text="LastName" th:for="LastName"></label> <input
					type="text" th:field="*{LastName}" name="lastName"
					placeholder="Last Name" value="${student.lastName}" />
			</div>
			<div style="clear: both; display: block; height: 10px"></div>
			<div>
				<select style="width:167px;" name="gender">
					<option value="Male" ${student.gender eq "Male" ? "selected":""}>Male</option>
					<option value="Female"${student.gender eq "Female" ? "selected":""}>Female</option>
				</select>
			</div>
			<div style="clear: both; display: block; height: 10px"></div>
			<div>
				<label th:text="Email" th:for="Email"></label> <input
					type="email" th:field="*{Email}" name="email"
					placeholder="Email" value="${student.email}" />
			</div>
			<div style="clear: both; display: block; height: 10px; margin-top:3px"></div>
		
			<div>
				<label th:text="Birthday" th:for="Birthday"></label> <input
					type="date" th:field="*{Birthday}" name="birthday"
					placeholder="Birthday" value="${student.birthday}" style="width:160px;"/>
			</div>
			<div style="clear: both; display: block; height: 10px"></div>
			<input type="submit" value="Edit Student" />
		</form>
	</div>
</body>
</html>