<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form  action="AptSchedule" align="center" >

Patient ID : <input type ="number" name="p_id" required><br><br>

Doctor Name: <input type ="text" name= "dname" required><br><br>

Appointment Date <input type ="text" name= "adate" required> & Time : <input type ="number" name="apt_hrs" required> : <input type ="number" name="apt_min" required><br><br>



<input type = "submit" value ="Schedule" >
</body>
</html>