<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.springframework.org/schema/data/jaxb">  
<head>  
    <meta charset="UTF-8">  
    <title>Add Person</title>  
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css" th:href="@{bootstrap.min.css}"/>  
</head>  
<body>  
<div class="col-3"></div>  
<div class="container col-6">  
    <h1>New Person</h1>  
    <div class="col-md-auto">  
        <form th:object="${person}" th:action="@{save}" action="save" modelAttribute="person" method="post">  
       		 <div>  
                <label th:text="IDString" th:for="idString"></label>  
                <input type="text" th:field="*{idString}" class="form-control"  name="idString" placeholder="idString"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
            <div>  
                <label th:text="firstName" th:for="firstName"></label>  
                <input type="text" th:field="*{firstName}" class="form-control" name="firstName" placeholder="firstName"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>  
            <div>  
                <label th:text="lastName" th:for="lastName"></label>  
                <input type="text" th:field="*{lastName}" class="form-control" name="lastName" placeholder="lastName"/>  
            </div>  
            <div>  
                <input type="radio"  value="Male" name="gender" checked/>  Male
                <input type="radio"  value="Female" name="gender"/>  Female
            </div> 
            <div style="clear: both; display: block; height: 10px"></div>  
            <input type="submit" class="btn btn-success" value="Save"/>  
        </form>  
    </div>  
</div>  
</body>  
</html>