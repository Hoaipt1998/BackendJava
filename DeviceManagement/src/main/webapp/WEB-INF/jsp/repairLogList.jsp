<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8" />
<title>Repair Log List</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<h1>Repair Log List</h1>

	<br />
	Device Serial No: ${device.serialNo }<br/>
	Device Serial No: ${device.name }<br/>
	<br />
	<a href="${pageContext.request.contextPath}/deviceList">Device List</a>  
	<div>
		<table border="1">
			<tr>
				<th>No.</th>
				<th>In Date</th>
				<th>In Status</th>
				<th>Out Date</th>
				<th>Out Status</th>
				<th>Note</th>
				
			</tr>
			<c:forEach items="${device.repairLogs}" var="log" varStatus="loop">
				<tr>
					<td>${loop.count}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${log.inDate}" /></td>
					<td>${log.statusIn} </td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${log.outDate}" /></td>
					<td>${log.statusOut} </td>
					<td>${log.note} </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>