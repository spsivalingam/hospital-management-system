<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="DocWorkinghrs" align="center" >
Doctor UserName : <input type ="text" name="duname" required><br><br>
Daily InTime : <input type="number" name="ihrs" required>hr :<input type="number" name="imin" required>min <br><br>
Daily OutTime: <input type="number" name="ohrs" required> hr: <input type="number" name="omin" required> min
<input type = "submit" value ="Update" >

</body>
</html>