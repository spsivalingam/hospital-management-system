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
   int appno = Integer.parseInt(session.getAttribute("o_appno").toString());	
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/HMS";
String username="root";
String password="admin";
String query="SELECT a.patient_id, e.user_name, a.apt_time from employee e inner join doctor d on e.employee_id = d.doctor_id inner join appointment a on d.doctor_id = a.doctor_id where a.apt_no = '"+appno+"'";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
%>
<form  action="UpdCanAppointment" align="center" >

Patient ID : <input type ="number" name="p_id" value=<%=rs.getString("a.patient_id")%> required><br><br>

Doctor Name: <input type ="text" name= "dname" value=<%=rs.getString("e.user_name")%> required><br><br>

Appointment Date: <input type ="datetime" name= "appdate" value=<%=rs.getString("a.apt_time")%> required><br><br>

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