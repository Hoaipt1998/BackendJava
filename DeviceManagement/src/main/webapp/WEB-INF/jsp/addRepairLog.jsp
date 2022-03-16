<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.springframework.org/schema/data/jaxb">  
<head>  
    <meta charset="UTF-8">  
    <title>Add Repair Log</title>  
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css" th:href="@{bootstrap.min.css}"/>  
</head>  
<body>  
<div class="col-3"></div>  
<div class="container col-6">  
    <h1>Device Repairing</h1>  
    <div class="col-md-auto">  
        <form th:object="${repairLog}" th:action="@{save}" action="saveRepairLog" modelAttribute="repairLog" method="post"> 
         	<div>  
                Device Serial No: ${repairLog.device.serialNo}
                <input type="hidden" th:field="*{device}" class="form-control"  name="device" placeholder="device" value="${repairLog.device.serialNo}"/> 
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>
            <div>  
                <label th:text="inDate" th:for="inDate"></label>  
                <fmt:formatDate value="<%= new java.util.Date() %>" pattern="dd/MM/yyyy" var="inDate"/>
                Date In: <input type="text" th:field="*{inDate}" class="form-control" name="inDate" value="${inDate}" placeholder="dateIn"/> (dd/mm/yyyy)  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>
            <div>  
                Status In: <label th:text="statusIn" th:for="statusIn"></label>  
                <input type="radio" name="statusIn" value="GOOD"  ${repairLog.device.status eq "GOOD" ? "checked" : ""}/>GOOD 
                <input type="radio" name="statusIn" value="ERROR"  ${repairLog.device.status eq "ERROR" ? "checked" : ""}/>ERROR 
                <input type="radio" name="statusIn" value="BROKEN" ${repairLog.device.status eq "BROKEN" ? "checked" : ""} />BROKEN 
                <input type="radio" name="statusIn" value="LIQUIDATION" ${repairLog.device.status eq "LIQUIDATION" ? "checked" : ""} />LIQUIDATION 
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
             <div>  
                <label th:text="outDate" th:for="outDate"></label>  
                Date Out: <input type="text" th:field="*{outDate}" class="form-control" name="outDate" placeholder="outDate"/> (dd/mm/yyyy)  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>
            <div>  
                Status Out: <label th:text="statusOut" th:for="statusOut"></label>  
                <input type="radio" name="statusOut" value="GOOD"/>GOOD 
                <input type="radio" name="statusOut" value="ERROR"  />ERROR 
                <input type="radio" name="statusOut" value="BROKEN"  />BROKEN 
                <input type="radio" name="statusOut" value="LIQUIDATION"  />LIQUIDATION 
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
             <div>  
                <label th:text="note" th:for="note"></label>  
                Note: <input type="text" th:field="*{note}" class="form-control" name="note" placeholder="note"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>
            
            <input type="submit" class="btn btn-success" value="Save"/>  
        </form>  
    </div>  
</div>  
</body>  
</html>