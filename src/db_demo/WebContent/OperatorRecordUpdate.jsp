<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	

	<form action="OprRecordUpdate">

		<table>
			<tr>
				<td><label path="oprUsername">Operator User Name :</label></td>
				<td><input type="text" name="oprUsername" required /></td>
			</tr>

			<tr>
				<td><label path="oprLastName">Operator Last Name :</label></td>
				<td><input type="text" name="oprLastName" required></td>
			</tr>

			<tr>
				<td><label path="oprFirstName">Operator First Name :</label></td>
				<td><input type="text" name="oprFirstName" required></td>
			</tr>
			
			<tr>
				<td><label path="addLine1">Address Line 1 :</label></td>
				<td><input type="text" name="addLine1" required></td>
			</tr>
			
			<tr>
				<td><label path="addLine2">Address Line 2 :</label></td>
				<td><input type="text" name="addLine2" required></td>
			</tr>
			
			<tr>
				<td><label path="city">City :</label></td>
				<td><input type="text" name="city" required></td>
			</tr>
			
			<tr>
				<td><label path="zipcode">Zipcode :</label></td>
				<td><input type="number" name="zipcode" required></td>
			</tr>
			
			<tr>
				<td><label path="emailAdd1">Email Address 1 :</label></td>
				<td><input type="email" name="emailAdd1" required></td>
			</tr>
			
			<tr>
				<td><label path="emailAdd2">Email Address 2 :</label></td>
				<td><input type="email" name="emailAdd2" required></td>
			</tr>
			
			<tr>
				<td><label path="mobileNo">Mobile Number :</label></td>
				<td><input type="number" name="mobileNo" required></td>
			</tr>

			<tr>
				<td>&nbsp &nbsp</td>
			</tr>

			<tr>
				<td colspan="10" align="left"><input type="submit"
					value="Update Operator's Record" /></td>
			</tr>
		</table>

	</form>

</body>
</html>