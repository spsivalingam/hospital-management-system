<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Records</title>
</head>
<body>
<form  action="PateintRecordsUpdation" align="center" >

PateintID : <input type ="number" name="pid" required><br><br>

Doctor : <input type ="text" name= "doc" required><br><br>

Disease : <input type ="text" name="disease" required><br><br>

Comments : <input type ="textarea" name="comments" required><br><br>

VisitedOn : <input type="text" name="viston" required><br><br>

Time : <input type="number" name="ihrs" required>hr :<input type="number" name="imin" required>min <br><br>

<input type = "submit" value ="Submit" >

</body>
</html>