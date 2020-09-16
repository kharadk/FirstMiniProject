<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<font color="green">${success}</font>
	<font color="green">${update}</font>
	<font color="red">${fail}</font>
	</br>
	<h2>Create New Contact</h2>

	<form:form action="/saveContact" method="post" modelAttribute="contact">
		<table>
			<tr>
				<td>Contact Name</td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="emailAddress" /></td>
			</tr>
			<tr>
				<td>Mobile No</td>
				<td><form:input path="mobileNo" /></td>
				<form:hidden path="cid" />
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		</br>
		<a href="viewContacts">View All Contact</a>
	</form:form>


</body>
</html>