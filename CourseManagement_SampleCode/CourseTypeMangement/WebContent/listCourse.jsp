<%@page import="course.CourseType"%>
<%@ page import = "java.sql.*,database.MyConnection" %>

<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>List of CourseTypes</title>
</head>

<body>
<form method="post" action="DeleteCourseServlet" name="deleteForm"> 
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="4">
		<p align="center"><b><font face="Tahoma" size="2">List Of Courses</font></b></td>
	</tr>
	<tr>
		<td width="3%" align="center"><b><font face="Tahoma" size="2">No.</font></b></td>
		<td width="17%" align="center"><b><font face="Tahoma" size="2">Code</font></b></td>
		<td width="30%" align="center"><b><font face="Tahoma" size="2">Name</font></b></td>
		
		<td width="10%" align="center"><b><font face="Tahoma" size="2">
		Credit</font></b></td>
		<td width="20%" align="center"><b><font face="Tahoma" size="2">
		Course Type</font></b></td>
		
		<td width="10%" align="center"><b><font face="Tahoma" size="2">
		<input type="submit" name="deleteButton" value="Delete"></font></b></td>
	</tr>
<%
		try{
		Connection conn = MyConnection.getConnection();
		if(conn != null)
		{
			String sql = "select id, code, name, credit, courseTypeID " +
			 			 "from course " +
			 			 "order by name ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int no = 0;
			CourseType ct = new CourseType();
			while(rs.next())
			{
				no++;
%>				

	<tr>
		<td>&nbsp;<%=no %></td>
		<td>&nbsp;<a href="updateCourse.jsp?id=<%=rs.getString("id")%>"> <%=rs.getString("code") %></a></td>
		<td>&nbsp;<%=rs.getString("name")!=null?rs.getString("name"):"" %></td>
		
		<td>&nbsp;<%=rs.getString("credit")%></td>
		<td>&nbsp;
		
		<%
			ct.setID(rs.getInt("CourseTypeID"));
			ct.getCourseTypeByID();
			out.print(ct.getName());
		%>
		
		</td>
		<td align="center">&nbsp;<input type="checkbox" name="idDelete" value="<%=rs.getString("id")%>"></td>		
	</tr>
<%
			}
			rs.close();
			stmt.close();
		}else
			out.println("Cannot connect to DB!");
		conn.close();
	}catch(Exception e)
	{
		
	}
%>	
</table>
<%
	String message = (String)request.getAttribute("message");
	if(message != null)
		out.print(message);
%>
<p align="center"><a href="addCourse.jsp">Add New Course</a></p>
</form>
</body>
</html>
