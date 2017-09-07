<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement"%> 
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="DoctorOptions.jsp"> Doctor Option Details </a><br><br>
<form method ="POST">
<table border="2">
<tr>
<td>Test ID</td>
<td>Patient Name </td>
<td> Test Name</td>
<td>Test Result </td>
<td>Test Taken ON </td>
</tr>

<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/HMS";
String username="root";
String password="admin";
String query= " SELECT pt.test_id, concat_ws(',',p.last_name,p.first_name) pname, pt.test_name , pt.test_result, pt.test_taken_on from patienttestresults pt  inner join patient p on pt.patient_id =p.patient_id order by pt.test_taken_on desc , pname; ";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>

<tr><td><%= rs.getInt("pt.test_id") %></td>
    <td><%= rs.getString("pname")%></td>
    <td><%= rs.getString("pt.test_name") %></td>
    <td><%= rs.getString("pt.test_result") %></td>
    <td><%= rs.getDate("pt.test_taken_on").toString() %></td> 
    </tr>
    
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
<br><br><br>



</form>
</body>
</html>