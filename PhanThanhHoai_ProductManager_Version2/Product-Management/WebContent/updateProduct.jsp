<%@page import="model.ProductType"%>
<%@page import="model.Product"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Update new Course</title>
</head>
<%
	String id = request.getParameter("id");
	Product pt = new Product();
	if(id != null){
		pt.setId(Integer.parseInt(id));
		pt.getProductTypeID();
			
%>
<body>

<%
	String name = "";
	if(null != session.getAttribute("name")){
	    HttpSession sesion = request.getSession();
		name = sesion.getAttribute("name").toString(); 
%>
<h1>Welcome, <%=name%><a href="Logout" style="font-size:25px; margin-left:30px;">Logout</a></h1>
<h1>Welcome, <%=name%></h1>
<form method="POST" action="UpdateProduct">
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">
		<p align="center"><b><font face="Tahoma" size="2">Update Product</font></b></td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Product Type:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
		
			<select name="productType">
			<%
				List<ProductType> listProductTypes = ProductType.getAllProductTypes();
					for(ProductType ct:listProductTypes){
						
						if(ct.getId() != pt.getProductType())
							out.print("<option value='" + ct.getId() + "'>" + ct.getName()  + "</option>");
						else
							out.print("<option value='" + ct.getId() + "' selected>" + ct.getName()  + "</option>");
					}
			%>
			
			</select>
			</font></font>
		</td>
	</tr>
	
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Name:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="name" value="<%=pt.getName() %>"><font size="2">
			</font></font>
		</td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Price:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input type="hidden" name="id" value="<%=pt.getId() %>">
			<input name="price" value="<%=pt.getPrice()%>"><font size="2">
			</font></font>
		</td>
	</tr>
	
	
	
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Description:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="description" value="<%=pt.getDescreption() %>"><font size="2">
			</font></font>
		</td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Status:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="status" value="<%=pt.getStatus() %>"><font size="2">
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
		response.sendRedirect("listProduct.jsp");
%>
<%} 
else {%>
	<h1>Please login <a href="Login.jsp">here</a></h1>
<% }%>
</body>

</html>