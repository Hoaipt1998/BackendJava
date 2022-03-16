<%@ page import = "java.sql.*,database.MyConnection" %>

<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>List of CourseTypes</title>
</head>

<body>
<form method="post" action="DeleteCourseTypeServlet" name="deleteForm"> 
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="4">
		<p align="center"><b><font face="Tahoma" size="2">List Of Course Types</font></b></td>
	</tr>
	<tr>
		<td width="3%" align="center"><b><font face="Tahoma" size="2">No.</font></b></td>
		<td width="40%" align="center"><b><font face="Tahoma" size="2">Name</font></b></td>
		<td width="47%" align="center"><b><font face="Tahoma" size="2">
		Description</font></b></td>
		<td width="10%" align="center"><b><font face="Tahoma" size="2">
		<input type="submit" name="deleteButton" value="Delete"></font></b></td>
	</tr>
<%
		try{
		Connection conn = MyConnection.getConnection();
		if(conn != null)
		{
			String sql = "select id, name, description " +
			 			 "from coursetype " +
			 			 "order by name ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int no = 0;
			while(rs.next())
			{
				no++;
%>				

	<tr>
		<td>&nbsp;<%=no %></td>
		<td>&nbsp;<a href="updateCourseType.jsp?id=<%=rs.getString("id")%>"> <%=rs.getString("name") %></a></td>
		<td>&nbsp;<%=rs.getString("description")!=null?rs.getString("description"):"" %></td>
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
<p align="center"><a href="addCourseType.jsp">Add New Course Type</a></p>
</form>
</body>
</html>
