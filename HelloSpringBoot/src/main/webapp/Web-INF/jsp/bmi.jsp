<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.springframework.org/schema/data/jaxb">  
<head>  
    <meta charset="UTF-8">  
    <title>BMI</title>  
</head>  
<body>  
<div class="col-3"></div>  
<div class="container col-6">  
    <h1>BMI Calculation</h1>  
    <div class="col-md-auto">  
        <form action="showBMI" modelAttribute="bmi" method="post">  
       		 <div>  
                Weight:
                <input type="text"  name="weight"/>  (Kg)
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
            <div>  
                Height:
                <input type="text"  name="height"/>  (m)
            </div>  
            
            <div style="clear: both; display: block; height: 10px"></div>  
            <input type="submit" class="btn btn-success" value="Calculate BMI"/>  
        </form>  
    </div>  
</div>  
</body>  
</html>