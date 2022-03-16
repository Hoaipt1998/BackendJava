<%@page import="student.Student"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Add new Student</title>
</head>

<body>
<form method="POST" action="AddStudentServlet">
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">
		<p align="center"><b><font face="Tahoma" size="2">Add Student</font></b></td>
	</tr>	
	
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Code:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="code"><font size="2">
			</font></font>
		</td>
	</tr>
	
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>First Name:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="firstName"><font size="2">
			</font></font>
		</td>
	</tr>
	
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Last Name:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="lastName"><font size="2">
			</font></font>
		</td>
	</tr>
	
	
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="79%"><font face="Tahoma">
		<input type="submit" value="Add" name="addButton"></font></td>
	</tr>
</table>
</form>

</body>

</html>