<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.springframework.org/schema/data/jaxb">  
<head>  
    <meta charset="UTF-8">  
    <title>Edit Device</title>  
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css" th:href="@{bootstrap.min.css}"/>  
</head>  
<body>  
<div class="col-3"></div>  
<div class="container col-6">  
    <h1>Edit Device</h1>  
    <div class="col-md-auto">  
        <form th:object="${device}" th:action="@{save}" action="editDeviceSave" modelAttribute="device" method="post">  
       		<div>  
       		<input type="hidden" name="photo" value="${device.photo}"/>
                <label th:text="deviceType" th:for="deviceType"></label>  
                Device Type: <select  name="deviceType">
						<c:forEach items="${deviceTypes}" var="deviceType">
							<option value="${deviceType.id}" ${deviceType.id eq device.deviceType.id ? "selected" : ""}>${deviceType.name}</option>
						</c:forEach>
				</select>
                
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>
             
       		 <div>  
                <label th:text="ID" th:for="ID"></label>  
                Serial Number: <input type="text" th:field="*{serialNo}" class="form-control"  name="serialNo" placeholder="serialNo" value="${device.serialNo}"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
            <div>  
                <label th:text="name" th:for="name"></label>  
                Name: <input type="text" th:field="*{name}" class="form-control"  value="${device.name}" name="name" placeholder="name" />  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>  
            <div>  
                <label th:text="manufacturer" th:for="manufacturer"></label>  
                Manufacture: <input type="text" th:field="*{manufacturer}" class="form-control"  value="${device.manufacturer}" name="manufacturer" placeholder="manufacturer"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>  
            <div>  
                <label th:text="importDate" th:for="importDate"></label>  
                <fmt:formatDate pattern="dd/MM/yyyy" value="${device.importDate}" var="importDate" />
                Import Date: <input type="text" th:field="*{importDate}" class="form-control" name="importDate" value="${importDate}" placeholder="importDate"/> (dd/mm/yyyy)  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>
            <div>  
                Status: <label th:text="status" th:for="status"></label>  
                <input type="radio" name="status" value="GOOD"  ${device.status eq "GOOD" ? "checked" : ""}/>GOOD 
                <input type="radio" name="status" value="ERROR"  ${device.status eq "ERROR" ? "checked" : ""}/>ERROR 
                <input type="radio" name="status" value="BROKEN" ${device.status eq "BROKEN" ? "checked" : ""} />BROKEN 
                <input type="radio" name="status" value="LIQUIDATION" ${device.status eq "LIQUIDATION" ? "checked" : ""} />LIQUIDATION 
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
            
            <input type="submit" class="btn btn-success" value="Edit Device"/>  
        </form>  
    </div>  
</div>  
</body>  
</html>