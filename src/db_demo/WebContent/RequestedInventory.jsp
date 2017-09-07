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



<body>
<form action="handlingRequests">

<table border="2">
<tr>
<td>Request ID</td>
<td>Doctor ID</td>
<td>Item Name</td>
<td>Required Quantity</td>
<td>Available Quantity</td>
<td>Accept</td>
<td>Reject</td>
</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/hms";
String username="root";
String password="admin";
String query="select r.request_id,r.doctor_id,r.item_name,r.quantity,i.quantity from request r inner join inventory i on r.item_name=i.item_name where r.status='INPROGRESS'";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
    <tr><td><input type="text" name="request_id" value=<%=rs.getString("request_id")%>></td>
    <td><input type="text" name="doctor_id" value=<%=rs.getString("doctor_id")%>></td>
    <td><input type="text" name="item_name" value=<%=rs.getString("item_name")%>></td>
    <td><input type="text" name="requiredQuantity" value=<%=rs.getString(4)%>></td>
    <td><input type="text" name="availableQuantity" value=<%=rs.getString(5)%>></td>
    <td><input type="submit" name="Accept" value="Accept"></td>
    <td><input type="submit" name="Reject" value="Reject"></td>
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
</form>

</body>
</html>