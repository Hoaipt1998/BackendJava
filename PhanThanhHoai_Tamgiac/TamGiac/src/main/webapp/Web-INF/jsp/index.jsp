<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8" />
<title>Welcome</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<h1>Welcome</h1>
	<h2>${message}</h2>
	<form action ="showResult" modelAttribute="tamgiac" method="post">
		<div>
			<label th:text="canh1" th:for="canh1"></label> <input type="text"
				th:field="*{canh1}" class="form-control" name="canh1"
				placeholder="side 1" />
		</div>
		<div style="clear: both; display: block; height: 10px"></div>
		<div>
			<label th:text="canh2" th:for="canh2"></label> <input type="text"
				th:field="*{canh2}" class="form-control" name="canh2"
				placeholder="side 2" />
		</div>
		<div style="clear: both; display: block; height: 10px"></div>
		<div>
			<label th:text="canh3" th:for="canh3"></label> <input type="text"
				th:field="*{canh3}" class="form-control" name="canh3"
				placeholder="side 3" />
		</div>
		<div style="clear: both; display: block; height: 10px"></div>
		<input type="submit" class="btn btn-success" value="Check" />
	</form>
</body>

</html>