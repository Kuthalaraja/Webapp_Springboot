<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<form action="/addAlien">
		Enter your Id : <input type="text" name="aid"><br> 
		Enter your Name : <input type="text" name="aname"><br> 
		<input type="submit">
	</form>
	
	<form action="/getAlien">
		Get Id : <input type="text" name="a"><br> 
		<input type="submit">
	</form>
	
	<form action="/updateAlien">
		Get Id : <input type="text" name="id"><br> 
		update user : <input type="text" name="name"><br> 
		<input type="submit">
	</form>
	
	<form action="/deleteAlien">
		Delete Id : <input type="text" name="a"><br> 
		<input type="submit">
	</form>
</body>
</body>
</html>