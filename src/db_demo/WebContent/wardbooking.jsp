<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="WardBooking" method ="POST">
Patient-ID: <input type="number" name = "Patient_id" required><br><br>
ICU<input type="radio" name = "wardType" value="ICU">
GENERAL<input type ="radio" name = "wardType" value="GENERAL" checked>
VIP<input type ="radio" name = "wardType" value="VIP"><br><br>
BED NUMBER: <input type="number" name = "bed_num" required><br><br>
<input type ="submit" value="Book">


</form>
</body>
</html>