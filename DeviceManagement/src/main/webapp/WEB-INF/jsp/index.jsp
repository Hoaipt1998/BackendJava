<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.springframework.org/schema/data/jaxb"> 
   <head>
      <meta charset="UTF-8" />
      <title>Welcome My Web Application</title>
      <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/css/style.css"/>
   </head>
   <body>
  <fmt:message key="app.title" />
  <fmt:message key="greeting" />
      <h1>Welcome</h1>
      <h2>${message}</h2>
      <a href="${pageContext.request.contextPath}/addDevice">Add Device</a>  <br/>
      <a href="${pageContext.request.contextPath}/deviceList">List of Devices</a><br/>
      <a href="${pageContext.request.contextPath}/upload">Upload a file</a>
   </body>
   
</html>