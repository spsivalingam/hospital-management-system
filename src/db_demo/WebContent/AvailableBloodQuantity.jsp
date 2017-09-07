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
<title>Available Blood Quantity</title>
</head>

<body>
<!-- <form action="updateBloodQuantity"> -->

<table border="2">
<tr>
<td>Blood Group</td>
<td>Quantity</td>
<!-- <td>Update</td>
 --></tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/hms";
String username="root";
String password="admin";
String query="select b.blood_group_name,b.quantity from bloodgroup b";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
    <tr><td><input type="text" name="bloodgroup_name" value=<%=rs.getString("blood_group_name")%>></td>
    <td><input type="text" name="blood_quantity" value=<%=rs.getInt("quantity")%>></td>
  
   	</tr>
        <%

}
%>
    </table>
    
    <a href="UpdateBloodQuantity.jsp">Update Blood Quantity</a>
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
<!-- </form> -->

</body>
</html>
