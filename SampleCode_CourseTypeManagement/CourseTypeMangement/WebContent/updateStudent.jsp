<%@page import="student.Student"%>
<%@ page import = "course.CourseType" %>
<html>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Update Student </title>
</head>
<% 
	String id = request.getParameter("id");
	Student student = new Student();
	if(id != null){
		student.setId(Integer.parseInt(id));
		student.getStudentByID();
	
%>

<body>
<form method="POST" action="UpdateStudentServlet">
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">
		<p align="center"><b><font face="Tahoma" size="2">Update Student</font></b></td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Code:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="id" type="hidden" value=<%=student.getId() %>>
			<input name="code" value=<%=student.getCode() %>><font size="2">
			</font></font>
		</td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>
		First Name:</b></font></td>
		<td width="79%"><font face="Tahoma">
		<input type="text" name="firstName" value="<%=student.getFirstName()%>"  size="20"></font></td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>
		Last Name:</b></font></td>
		<td width="79%"><font face="Tahoma">
		<input type="text" name="lastName" value="<%=student.getLastName()%>"  size="20"></font></td>
	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="79%"><font face="Tahoma">
		<input type="submit" value="Update" name="updateButton"></font></td>
	</tr>
</table>
</form>

</body>
<%
	}//end of if statement
	else
		response.sendRedirect("listStudent.jsp");
%>
</html>