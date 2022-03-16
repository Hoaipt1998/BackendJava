<%@page import="model.producttype"%>
<%@ page import = "java.sql.*,database.connectiondb" %>

<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>List of CourseTypes</title>
</head>

<body>
<form method="post" action="DeleteProducttype" name="deleteForm"> 
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="4">
		<p align="center"><b><font face="Tahoma" size="2">List Of Product Types</font></b></td>
	</tr>
	<tr>
		<td width="3%" align="center"><b><font face="Tahoma" size="2">No.</font></b></td>
		<td width="17%" align="center"><b><font face="Tahoma" size="2">name</font></b></td>
		<td width="30%" align="center"><b><font face="Tahoma" size="2">description</font></b></td>
		
		<td width="10%" align="center"><b><font face="Tahoma" size="2">
		Credit</font></b></td>
		<td width="20%" align="center"><b><font face="Tahoma" size="2">
		Course Type</font></b></td>
		
		<td width="10%" align="center"><b><font face="Tahoma" size="2">
		<input type="submit" name="deleteButton" value="Delete"></font></b></td>
	</tr>
<%
		try{
		Connection conn = connectiondb.getConnection();
		if(conn != null)
		{
			String sql = "select id, name, description,status " +
			 			 "from producttype " +
			 			 "order by name ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int no = 0;
			producttype pt = new producttype();
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
			pt.setId(rs.getInt("id"));
			pt.getDescreption();
			out.print(pt.getName());
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

<p align="center"><a href="addProduct.jsp">Add New Product</a></p>
</form>
</body>
</html>
