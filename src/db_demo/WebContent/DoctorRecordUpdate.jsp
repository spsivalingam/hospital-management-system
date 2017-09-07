<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- <p>${updateMsgSuccess}</p>
	<p>${updateMsgUnSuccess}</p>
	<c:remove var="updateMsgSuccess" scope="session" />
	<c:remove var="updateMsgUnSuccess" scope="session" /> --%>

	<form action="DocRecordUpdate">

		<table>
			<tr>
				<td><label path="docUsername">Doctor User Name :</label></td>
				<td><input type="text" name="docUsername" /></td>
			</tr>

			<tr>
				<td><label path="degree">Degree :</label></td>
				<td><input type="text" name="degree"></td>
			</tr>

			<tr>
				<td><label path="special">Specialization :</label></td>
				<td><input type="text" name="special"></td>
			</tr>

			<!-- <tr>
				<td><label path="inTime">Daily InTime :</label></td>
				<td><input type="number" name="inTimeHr"></td>
				<td><label path="inTime">hr :</label></td>
				<td><input type="number" name="inTimeMin"></td>
				<td><label path="inTime">min :</label></td>
			</tr>

			<tr>
				<td><label path="outTime">Daily OutTime :</label></td>
				<td><input type="number" name="outTimeHr"></td>
				<td><label path="inTime">hr :</label></td>
				<td><input type="number" name="outTimeMin"></td>
				<td><label path="inTime">min :</label></td>
			</tr> -->

			<tr>
				<td>&nbsp &nbsp</td>
			</tr>

			<tr>
				<td colspan="10" align="left"><input type="submit"
					value="Update Doctor's Record" /></td>
			</tr>
		</table>

	</form>

</body>
</html>