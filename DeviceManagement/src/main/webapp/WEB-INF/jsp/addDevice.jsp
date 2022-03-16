<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.springframework.org/schema/data/jaxb">  
<head>  
    <meta charset="UTF-8">  
    <title>Add Device</title>  
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css" th:href="@{bootstrap.min.css}"/>  
</head>  
<body>  
<div class="col-3"></div>  
<div class="container col-6">  
    <h1>New Device</h1>  
    <div class="col-md-auto">  
        <form th:object="${device}" enctype="multipart/form-data" th:action="@{save}" action="saveDevice" modelAttribute="device" method="post"> 
         	<div>  
                <label th:text="deviceType" th:for="deviceType"></label>  
                Device Type: <select  name="deviceType">
						<c:forEach items="${deviceTypes}" var="deviceType">
							<option value="${deviceType.id}">${deviceType.name}</option>
						</c:forEach>
				</select>
                
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>
             
       		 <div>  
                <label th:text="ID" th:for="ID"></label>  
                Serial Number: <input type="text" th:field="*{serialNo}" class="form-control"  name="serialNo" placeholder="serialNo"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
            <div>  
                <label th:text="name" th:for="name"></label>  
                Name: <input type="text" th:field="*{name}" class="form-control" name="name" placeholder="name"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>  
            <div>  
                <label th:text="manufacturer" th:for="manufacturer"></label>  
                Manufacture: <input type="text" th:field="*{manufacturer}" class="form-control" name="manufacturer" placeholder="manufacturer"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>  
            <div>  
                <label th:text="importDate" th:for="importDate"></label>  
                Import Date: <input type="text" th:field="*{importDate}" class="form-control" name="importDate" placeholder="importDate"/> (dd/mm/yyyy)  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>
            <div>  
                Status: <label th:text="status" th:for="status"></label>  
                <input type="radio" name="status" value="GOOD"  checked="checked"/>GOOD 
                <input type="radio" name="status" value="ERROR"  />ERROR 
                <input type="radio" name="status" value="BROKEN"  />BROKEN 
                <input type="radio" name="status" value="LIQUIDATION"  />LIQUIDATION 
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
            <div>
            <input type="file" name="photoUpload" />
            </div>
            <div style="clear: both; display: block; height: 10px"></div> 
            <input type="submit" class="btn btn-success" value="Save"/>  
        </form>  
    </div>  
</div>  
</body>  
</html>