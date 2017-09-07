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
<a href="wardbooking.jsp"> Allocate ward and bed for a patient </a><br><br>
<a href="OperatorOptions.jsp"> Operator Options Page</a>
<form method ="POST">
<table border="2">
<tr>
<td>WARD TYPE </td>
<td>Occupaied </td>
<td>Maximum Capacity </td>
</tr>

<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/HMS";
String username="root";
String password="admin";
String query="SELECT w.ward_type, w.capacity, COUNT(a.patient_id) as Occupaied from AdmittedPatients a right join Wards w on a.ward_id = w.ward_id group by w.ward_type";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>

<tr><td><%=rs.getString("w.ward_type") %></td>
    <td><%=rs.getInt("Occupaied")%></td>
    <td><%=rs.getInt("w.capacity") %></td>
    
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
<table>
<tr>
<td>ICU WardDetails</td>
<td><a href= "icudetails.jsp"> ICU Ward Patient Details </a></td>
</tr>

<tr>
<td>General WardDetails</td>
<td><a href= "gendetails.jsp"> General Ward Patient Details </a></td>
</tr>

<tr>
<td>ICU WardDetails</td>
<td><a href= "vipdetails.jsp"> VIP Ward Patient Details </a></td>
</tr>

</table>


</form>


</body>
</html>