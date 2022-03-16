<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8" />
<title>Device List</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<h1>List of devices</h1>

	<br />
	<br />
	<a href="${pageContext.request.contextPath}/addDevice">Add Device</a>  
	<div>
		<table border="1">
			<tr>
				<th>No.</th>
				<th>Serial No.</th>
				<th>Name</th>
				<th>Photo</th>
				<th>Manufacturer</th>
				<th>Import Date</th>
				<th>Device Type</th>
				<th>Status</th>
				<th>Edit</th>
				<th>Delete</th>
				<th>Repair</th>
				<th>Repair Log</th>
			</tr>
			<c:forEach items="${devices}" var="device" varStatus="loop">
				<tr>
					<td>${loop.count}</td>
					<td>${device.serialNo}</td>
					<td>${device.name} </td>
					<td><img src="${pageContext.request.contextPath}/storefiles/${device.photo}" alt="Device Image" width="100" height="100"></td>
					<td>${device.manufacturer}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${device.importDate}" /></td>
					<td>${device.deviceType.getName()}</td>
					
					<td>${device.status}</td>
					<th><a href="editDevice?id=<c:out value='${device.serialNo}'/>">Edit</a></th>
					<th><a href="deleteDevice?id=<c:out value='${device.serialNo}'/>">Delete</a></th>
					<th>
					<c:if test = "${device.status eq 'ERROR'}">
					<c:choose>
					<c:when test="${not empty device.findRepairing() }">
					<a href="resultRepairLog?id=<c:out value='${device.findRepairing().id}'/>">Repair Result</a>
					</c:when>
					<c:otherwise>
					<a href="addRepairLog?id=<c:out value='${device.serialNo}'/>">Repair</a>
					</c:otherwise>
					</c:choose>
					</c:if>
					
					</th>
					
					<th>
					<c:if test="${device.repairLogs.size()>0}">
					<a href="listRepairLog?serialNo=<c:out value='${device.serialNo}'/>">Log</a>
					</c:if>
					</th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>