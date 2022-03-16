<%@page import="model.Product"%>
<%@page import="model.ProductType"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page import = "java.sql.*,database.ConnectionDB" %>

<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>List of CourseTypes</title>
</head>

<body>
<%
	String name = "";
	if(null != session.getAttribute("name")){
	    HttpSession sesion = request.getSession();
		name = sesion.getAttribute("name").toString(); 
%>
<h1>Welcome, <%=name%><a href="Logout" style="font-size:25px; margin-left:30px;">Logout</a></h1>


<form method="post" action="DeleteProduct" name="deleteForm"> 
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="7">
		<p align="center"><b><font face="Tahoma" size="2">List Of Product</font></b></td>
	</tr>
	<tr>
		<td width="3%" align="center"><b><font face="Tahoma" size="2">No.</font></b></td>
		<td width="22%" align="center"><b><font face="Tahoma" size="2">Name</font></b></td>
		<td width="10%" align="center"><b><font face="Tahoma" size="2">Price</font></b></td>
		<td width="30%" align="center"><b><font face="Tahoma" size="2">Description</font></b></td>
		<td width="10%" align="center"><b><font face="Tahoma" size="2">Status</font></b></td>
		<td width="15%" align="center"><b><font face="Tahoma" size="2">
		Product Type</font></b></td>
		
		<td width="10%" align="center"><b><font face="Tahoma" size="2">
		<input type="submit" name="deleteButton" value="Delete"></font></b></td>
	</tr>
<%
	try{
		Connection conn = ConnectionDB.getConnection();
		if(conn != null)
		{
	String sql = "select id, name, price, description,status,producttype " +
	 			 "from product";
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	ProductType pt = new ProductType();
	int no = 0;
	while(rs.next())
	{
		no++;
%>				

	<tr>
		<td>&nbsp;<%=no %></td>
		<td>&nbsp;<a href="updateProduct.jsp?id=<%=rs.getString("id")%>"><%=rs.getString("name")%></a></td>
		
		<td>&nbsp;<%=rs.getString("price")%></td>
			
		<td>&nbsp;<%=rs.getString("description")%></td>
		<td>&nbsp;<%=rs.getString("status")%></td>
		<td>&nbsp;
		
		<%
			pt.setId(rs.getInt("productType"));
			pt.getProductTypeByID();
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
<%
	String message = (String)request.getAttribute("message");
	if(message != null)
		out.print(message);
%>
<p align="center"><a href="addProduct.jsp">Add New Product</a></p>
</form>
<%} 
else {%>
	<h1>Please login <a href="Login.jsp">here</a></h1>
<% }%>
</body>
</html>
