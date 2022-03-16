<%@ page import = "java.sql.*,database.MyConnection" %>

<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>List of Student</title>
</head>

<body>
<form method="post" action="DeleteStudentServlet" name="deleteForm"> 
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="4">
		<p align="center"><b><font face="Tahoma" size="2">List Of Student</font></b></td>
	</tr>
	<tr>
		<td width="3%" align="center"><b><font face="Tahoma" size="2">No.</font></b></td>
		<td width="40%" align="center"><b><font face="Tahoma" size="2">Last Name</font></b></td>
		<td width="40%" align="center"><b><font face="Tahoma" size="2">First Name</font></b></td>
		<td width="40%" align="center"><b><font face="Tahoma" size="2">Gender</font></b></td>
		<td width="40%" align="center"><b><font face="Tahoma" size="2">Email</font></b></td>
		<td width="40%" align="center"><b><font face="Tahoma" size="2">Phone Number</font></b></td>
		<input type="submit" name="deleteButton" value="Delete"></font></b></td>
	</tr>
<%
		try{
		Connection conn = MyConnection.getConnection();
		if(conn != null)
		{
			String sql = "select id, lastName, firstName, gender, email, phoneNumber " +
			 			 "from student " +
			 			 "order by firstName ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int no = 0;
			while(rs.next())
			{
				no++;
%>				

	<tr>
		<td>&nbsp;<%=no %></td>
		<td>&nbsp;<a href="updateStudent.jsp?id=<%=rs.getString("id")%>"> <%=rs.getString("lastName") %></a></td>
		<td>&nbsp;<%=rs.getString("firstName")!=null?rs.getString("firstName"):"" %></td>
		<td>&nbsp;<%=rs.getString("gender")!=null?rs.getString("gender"):"" %></td>
		<td>&nbsp;<%=rs.getString("email")!=null?rs.getString("email"):"" %></td>
		<td>&nbsp;<%=rs.getString("phoneNumber")!=null?rs.getString("phoneNumber"):"" %></td>		
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
<p align="center"><a href="addStudent.jsp">Add New Student</a></p>
</form>
</body>
</html>
