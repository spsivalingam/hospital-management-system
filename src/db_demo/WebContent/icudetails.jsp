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
<form method ="POST">
<table border="1">
<tr>
<td>PATIENT ID </td>
<td>PATIENT NAME </td>
<td> BED NUMBER </td>
</tr>

<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/HMS";
String username="root";
String password="admin";
/*String query = "SELECT p.patient_id, CONCAT(p.first_name,p.last_name)AS pname,a.bed_number FROM Patient p INNER JOIN AdmittedPatients a ON a.patient_id = p.patient_id INNER JOIN Wards w ON w.ward_id = a.ward_id WHERE w.ward_type = 'ICU'";*/
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery("SELECT p.patient_id, CONCAT(p.first_name,p.last_name)AS pname,a.bed_number FROM Patient p INNER JOIN AdmittedPatients a ON a.patient_id = p.patient_id INNER JOIN Wards w ON w.ward_id = a.ward_id WHERE w.ward_type = 'ICU'");
while(rs.next())
{

%>

<tr><td><%=rs.getString("p.patient_id") %></td>
    <td><%=rs.getString("pname")%></td>
    <td><%=rs.getString("a.bed_number") %></td>
   
    
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
<a href= "warddetails.jsp"> Pateint Ward Details </a><br><br>
<a href= "deallocateward.jsp">De-Allocate Beds in wards </a>


</form>
</body>
</html>