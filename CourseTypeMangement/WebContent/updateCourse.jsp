<%@page import="course.CourseType"%>
<%@page import="course.Course"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Update new Course</title>
</head>
<% 
	String id = request.getParameter("id");
	Course c = new Course();
	if(id != null){
		c.setId(Integer.parseInt(id));
		c.getCourseByID();	
%>
<body>

<form method="POST" action="UpdateCourseServlet">
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">
		<p align="center"><b><font face="Tahoma" size="2">Update Course</font></b></td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Course Type:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
		
			<select name="courseTypeID">
			<%
				List<CourseType> listCourseTypes = CourseType.getAllCourseTypes();
				for(CourseType ct:listCourseTypes){
					
					if(ct.getID() != c.getCourseTypeID())
						out.print("<option value='" + ct.getID() + "'>" + ct.getName()  + "</option>");
					else
						out.print("<option value='" + ct.getID() + "' selected>" + ct.getName()  + "</option>");
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
			<input type="hidden" name="id" value="<%=c.getId() %>">
			<input name="code" value="<%=c.getCode() %>"><font size="2">
			</font></font>
		</td>
	</tr>
	
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Name:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="name" value="<%=c.getName() %>"><font size="2">
			</font></font>
		</td>
	</tr>
	
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Credit:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="credit" value="<%=c.getCredit() %>"><font size="2">
			</font></font>
		</td>
	</tr>
	
	
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="79%"><font face="Tahoma">
		<input type="submit" value="update" name="updateButton"></font></td>
	</tr>
</table>
</form>
<%
	}//end of if statement
	else
		response.sendRedirect("listCourse.jsp");
%>
</body>

</html>