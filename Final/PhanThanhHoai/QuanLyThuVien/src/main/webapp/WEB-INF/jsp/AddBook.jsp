<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.springframework.org/schema/data/jaxb">  
<head>  
    <meta charset="UTF-8">  
    <title>Add Book</title>  
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css" th:href="@{bootstrap.min.css}"/>  
</head>  
<body>  
<div class="col-3"></div>  
<div class="container col-6">  
    <h1>New Book</h1>  
    <div class="col-md-auto">  
        <form th:object="${book}" th:action="@{save}" action="save" modelAttribute="book" method="post">  
       		 <div>  
                <label th:text="barcode" th:for="barcode"></label>  
                <input type="text" th:field="*{barcode}" class="form-control"  name="barcode" placeholder="barcode"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
            <div>  
                <label th:text="title" th:for="title"></label>  
                <input type="text" th:field="*{title}" class="form-control" name="title" placeholder="title"/>  
            </div>  
            <div style="clear: both; display: block; height: 10px"></div>  
            <div>  
                <label th:text="author" th:for="author"></label>  
                 <input type="text" th:field="*{author}" class="form-control" name="author" placeholder="author"/>  
         
            </div>  
            <div>  
                <label th:text="description" th:for="description"></label>  
                <input type="text" th:field="*{description}" class="form-control"  name="description" placeholder="description"/>  
            </div> 
            <div style="clear: both; display: block; height: 10px"></div>  
             <div>  
                <label th:text="price" th:for="price"></label>  
                <input type="text" th:field="*{price}" class="form-control"  name="price" placeholder="price"/>  
            </div> 
            <div style="clear: both; display: block; height: 10px"></div>  
            <input type="submit" class="btn btn-success" value="Save"/>  
        </form>  
    </div>  
</div>  
</body>  
</html>