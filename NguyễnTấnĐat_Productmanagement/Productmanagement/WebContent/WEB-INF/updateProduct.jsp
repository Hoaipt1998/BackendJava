<%@page import="model.producttype"%>
<%@page import="model.product"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Update new Course</title>
</head>
<% 
	String id = request.getParameter("id");
	product pt = new product();
	if(id != null){
		pt.setId(Integer.parseInt(id));
		pt.GetProductbyID();	
%>
<body>

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
		
			<select name="courseTypeID">
			<%
				List<producttype> listProductTypes = producttype.getAllProductTypes();
				for(producttype ct:listProductTypes){
					
					if(ct.getId() != pt.getProdcutTypeID())
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
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Code:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input type="hidden" name="id" value="<%=pt.getId() %>">
			<input name="code" value="<%=pt.getName( )%>"><font size="2">
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
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Credit:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="credit" value="<%=pt.getDescreption() %>"><font size="2">
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
</body>

</html>