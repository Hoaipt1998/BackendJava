<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>

<h2>Register Form</h2>

<form action="AddAdmin" method="post">  
  <div class="container">
  
  	 <label for="uname"><b>First Name:</b></label>
    <input type="text" placeholder="Enter FristName" name="firstname" required>
    
     <label for="uname"><b>Last Name:</b></label>
    <input type="text" placeholder="Enter LastName" name="lastname" required>
    
     <label for="uname"><b>Email:</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>
    
     <label for="uname"><b>Phone:</b></label>
    <input type="text" placeholder="Enter Phone" name="phone" required>
    
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button type="submit" value="addButton">Register</button>
   
  </div>
<div class="container" style="background-color:#f1f1f1">
   <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw"><a href="Login.jsp">Login?</a></span>
  </div>
</form>
<%
	String message = (String)request.getAttribute("message");
	if(message != null)
		out.print(message);
%>
</body>
</html>