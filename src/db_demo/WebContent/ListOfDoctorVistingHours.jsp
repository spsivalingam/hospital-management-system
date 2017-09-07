<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   


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

<a href="apointmentScheduleing.jsp">Appointment Scheduling for Patients</a>
<br><br><br><br><br><br><br>

<body>
<form method="post">

<table border="2">
<tr>
<td>Doctor Name</td>
<td>Daily INTIME</td>
<td>Daily OUTTIME</td>
</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/HMS";
String username="root";
String password="admin";
String query="select e.first_name, d.in_time,d.out_time from Employee e inner join Doctor d on e.employee_id=d.doctor_id";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
    <tr><td><%=rs.getString("first_name") %></td>
    <td><%=rs.getString("in_time")%></td>
    <td><%=rs.getString("out_time") %></td></tr>
        <%

}
%>
    </table>
    <%
    rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }




%>
</form>

</body>
</html>