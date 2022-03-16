<%@page import="course.Student"%>
<%@page import="course.Course"%>
<%@page import="java.util.List"%>
<%@page import="course.CourseType"%>
<%@ page import = "java.sql.*,database.MyConnection" %>

<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Registration Page</title>
</head>
<%
	String studentID = request.getParameter("studentID");
	if(studentID == null)
		studentID = request.getParameter("studentIDRedirect");
	if(studentID == null)
		studentID = "-1";
	
%>


<body>
<form method="post" action="" name="loadDataForm"> 
<p><font face="Tahoma"><b>Select Student: </b><font size="3">
<select size="1" onchange="this.form.submit()" name="studentID" style="font-weight: 700">
<option value="-1">Select student</option>
<%
	List<Student> listStudents = Student.getAllStudents();
	for(Student st:listStudents){
		if(st.getId() != Integer.parseInt(studentID))
			out.print("<option value='" + st.getId() + "'>" + 
					st.getCode() + " - " + st.getLastName() + " " + st.getFirstName()  + "</option>");
		else
			out.print("<option value='" + st.getId() + "' selected>" + 
					st.getCode() + " - " + st.getLastName() + " " + st.getFirstName()  + "</option>");
	}
%>
</select></font></font></p>
</form>


<form method="post" action="DeleteRegisterCourseServlet" name="deleteForm"> 
<input type="hidden" name="studentID" value="<%=studentID %>"/>
<table border="1" width="100%" id="table1" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="6">
		<p align="center"><b><font face="Tahoma" size="2">List Of Registered 
		Course(s)</font></b></td>
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
		if(!studentID.equals("-1"))
		{
			int no = 0;
			Student st = new Student();
			st.setId(Integer.parseInt(studentID));
			CourseType ct = new CourseType();
			List<Course> listRegisterCourse = st.getRegisteredCourse();
			for(Course c:listRegisterCourse)
			{
				no++;
%>				

	<tr>
		<td>&nbsp;<%=no %></td>
		<td>&nbsp; <%=c.getCode()%></td>
		<td>&nbsp;<%=c.getName()%></td>
		<td>&nbsp;<%=c.getCredit()%></td>
		<td>&nbsp;
		<%
			ct.setID(c.getCourseTypeID());
			ct.getCourseTypeByID();
			out.print(ct.getName());
		%>
		</td>
		<td align="center">&nbsp;<input type="checkbox" name="idDelete" value="<%=c.getId()%>"></td>		
	</tr>
<%
			}
		}
	
%>	
</table>
</form>
<form method="post" action="RegisterCourseServlet" name="regisForm"> 
<input type="hidden" name="studentID" value="<%=studentID %>"/>
<%
	String message = (String)request.getAttribute("message");
	if(message != null)
		out.print(message);
%>
<p align="center">&nbsp;</p> 
<table border="1" width="100%" id="table2" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="6">
		<p align="center"><b><font face="Tahoma" size="2">List Of Offered 
		Course(s)</font></b></td>
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
		<input type="submit" name="registerButton" value="Register"></font></b></td>
	</tr>
<%
		if(!studentID.equals("-1"))
		{
			int no = 0;
			Student st = new Student();
			st.setId(Integer.parseInt(studentID));
			CourseType ct = new CourseType();
			List<Course> listOfferCourse = st.getOfferedCourse();
			for(Course c:listOfferCourse)
			{
				no++;
%>				

	<tr>
		<td>&nbsp;<%=no %></td>
		<td>&nbsp; <%=c.getCode()%></td>
		<td>&nbsp;<%=c.getName()%></td>
		<td>&nbsp;<%=c.getCredit()%></td>
		<td>&nbsp;
		
		<%
			ct.setID(c.getCourseTypeID());
			ct.getCourseTypeByID();
			out.print(ct.getName());
		%>
		
		</td>
		<td align="center">&nbsp;<input type="checkbox" name="idRegister" value="<%=c.getId()%>"></td>		
	</tr>

<%
			}
		}
	
%>		
</table>

</body>
</html>
