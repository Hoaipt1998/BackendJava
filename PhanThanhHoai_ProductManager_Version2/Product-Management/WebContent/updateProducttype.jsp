<%@ page import = "model.ProductType" %>
<html>
<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Update Course Type</title>
</head>
<%
	String id = request.getParameter("id");
	ProductType c = new ProductType();
	if(id != null){
		c.setId(Integer.parseInt(id));
		c.GetProductbyID();
%>

<body>
<form method="POST" action="UpdateProducttype">
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">
		<p align="center"><b><font face="Tahoma" size="2">Update Course Type</font></b></td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>Name:</b></font></td>
		<td width="79%" >
			<font face="Tahoma">
			<input name="id" type="hidden" value=<%=c.getId() %>>
			<input name="name" value=<%=c.getName() %>><font size="2">
			</font></font>
		</td>
	</tr>
	<tr>
		<td width="20%" align="right"><font face="Tahoma" size="2"><b>
		Description:</b></font></td>
		<td width="79%"><font face="Tahoma">
		<input type="text" name="description" value=<%=c.getDescreption() %>  size="20"></font></td>
	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="79%"><font face="Tahoma">
		<input type="submit" value="Update" name="updateButton"></font></td>
	</tr>
</table>
</form>

</body>
<%
	}//end of if statement
	else
		response.sendRedirect("listProducttype.jsp");
%>
</html>