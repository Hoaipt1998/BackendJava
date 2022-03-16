<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.springframework.org/schema/data/jaxb">  
<head> 
<body>

<h1>Spring Boot - Upload Status</h1>

<div >
    <h2>${message}</h2>
</div>
<a href="${pageContext.request.contextPath}/upload">Upload a file</a>
</body>
</html>