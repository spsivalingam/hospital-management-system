<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="PatientRegister" align="center" >
FirstName : <input type ="text" name="f_name"><br><br>

LastName : <input type ="text" name="l_name"><br><br>

Age : <input type ="number" min="1" max="150" name="age"><br><br>

<input type="radio" name="gender" value="male"> Male<br>

 <input type="radio" name="gender" value="female">Female<br>
  
 <input type="radio" name="gender" value="other">Other<br><br>
  
  
AddressLine1 : <input type ="text" name="addr1"><br><br>

AddressLine2 : <input type ="text" name="addr2"><br><br>

City : <input type ="text" name="city"><br><br>

ZipCode : <input type ="number" name="zip_code"><br><br>

Primary E-MailID : <input type ="email" name="email1"><br><br>

Secondary E-MailID : <input type ="email" name="email2"><br><br>

Mobile Number : <input type ="number" name="mobile_no"><br><br>

Emergency Contact Number : <input type ="number" name="e_mobile_no"><br><br>

<input type = "submit" value ="register" >
</form>
</body>
</html>