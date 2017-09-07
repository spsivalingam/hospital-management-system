<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement"%> 
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try
{
	//HttpSession session = request.getSession();
   int pid = Integer.parseInt(session.getAttribute("o_pid").toString());	
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/HMS";
String username="root";
String password="admin";
String query="SELECT last_name,first_name,age,sex,addr_line1,addr_line2,city,zip_code,email_id_1,email_id_2,mobile_number,e_mobile_number from patient where patient_id = '"+pid+"'";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
%>
<form  action="PatientPersonalRecUpd" align="center" >

FirstName : <input type ="text" name="f_name" value=<%=rs.getString("first_name")%>><br><br>

LastName : <input type ="text" name="l_name" value=<%=rs.getString("last_name") %>><br><br>

Age : <input type ="number" min="1" max="150" name="age" value =<%=rs.getInt("age") %>><br><br>
 
AddressLine1 : <input type ="text" name="addr1" value =<%=rs.getString("addr_line1")%>><br><br>

AddressLine2 : <input type ="text" name="addr2" value =<%=rs.getString("addr_line2")%>><br><br>

City : <input type ="text" name="city" value =<%=rs.getString("city")%>><br><br>

ZipCode : <input type ="number" name="zip_code" value =<%=rs.getString("zip_code") %>><br><br>

Primary E-MailID : <input type ="email" name="email1" value =<%=rs.getString("email_id_1")%>><br><br>

Secondary E-MailID : <input type ="email" name="email2" value =<%=rs.getString("email_id_2")%>><br><br>

Mobile Number : <input type ="number" name="mobile_no" value =<%=rs.getString("mobile_number")%>><br><br>

Emergency Contact Number : <input type ="number" name="e_mobile_no" value =<%=rs.getString("e_mobile_number")%>><br><br>

<input type = "submit" value ="register" >

</form>
   
    <%
}
    rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }
%>

</body>
</html>