<%@page import="course.CourseType"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Add new Course</title>
</head>

<body>
<form method="POST" action="AddCourseServlet">
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">
		<p align="center"><b><font face="Tahoma" size="2">Add Course</font></b></td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Course Type:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
		
			<select name="courseTypeID">
			<%
				List<CourseType> listCourseTypes = CourseType.getAllCourseTypes();
				for(CourseType ct:listCourseTypes){
					out.print("<option value='" + ct.getID() + "'>" + ct.getName()  + "</option>");
				}
			%>
			
			</select>
			</font></font>
		</td>
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
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Name:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="name"><font size="2">
			</font></font>
		</td>
	</tr>
	
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Credit:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="credit"><font size="2">
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