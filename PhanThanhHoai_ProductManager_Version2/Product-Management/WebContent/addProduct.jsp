<%@page import="model.ProductType"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>
<html>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Add new Product</title>
</head>

<body>
<%
	String name = "";
	if(null != session.getAttribute("name")){
	    HttpSession sesion = request.getSession();
		name = sesion.getAttribute("name").toString(); 
%>
<h1>Welcome, <%=name%><a href="Logout" style="font-size:25px; margin-left:30px;">Logout</a></h1>
<h1>Welcome, <%=name%></h1>
<form method="POST" action="AddProduct">
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">
		<p align="center"><b><font face="Tahoma" size="2">Add Product</font></b></td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Product:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
		
			<select name="id">
			<%
				List<ProductType> listprod = ProductType.getAllProductTypes();
					for(ProductType pt:listprod){
						out.print("<option value='" + pt.getId() + "'>" + pt.getName()  + "</option>");
					}
			%>
			
			</select>
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
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Price:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="price"><font size="2">
			</font></font>
		</td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Description:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="description"><font size="2">
			</font></font>
		</td>
	</tr>
	
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Status:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="status"><font size="2">
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
<%} 
else {%>
	<h1>Please login <a href="Login.jsp">here</a></h1>
<% }%>
</body>

</html>