<!DOCTYPE html>  
<html lang="en" xmlns:th="http://www.springframework.org/schema/data/jaxb">  
<head>  
    <meta charset="UTF-8">  
    <title>BMI</title>  
</head>  
<body>  
<div class="col-3"></div>  
<div class="container col-6">  
    <h1>BMI Information</h1>  
    <div class="col-md-auto">  
       		 <div>  
                Weight: ${bmi.weight} (Kg)
            </div>  
            <div style="clear: both; display: block; height: 10px"></div> 
            <div>  
                Height: ${bmi.height} (m)
            </div> 
            
            <div style="clear: both; display: block; height: 10px"></div>  
              <div>  
                BMI: ${bmi.bmi} (m)
            </div> 

    </div>  
</div>  
</body>  
</html>