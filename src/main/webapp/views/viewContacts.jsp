
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" style="color: blue;background: yellow;">
  function confirmDelete(){
         return confirm("Are you sure,you want to delete?");
	  }

</script>
</head>

<font color="green">${delete}</font></br>
<body>
	<a href="/"> Add New Contact </a>
	<table border="1" style="font-family: sans-serif;">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Phno</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>${contact.contactName }</td>
				<td>${contact.emailAddress }</td>
				<td>${contact.mobileNo}</td>

				<td><a href="editContact?cid=${contact.cid}">Edit</a>
				 <a href="deleteContact?cid=${contact.cid}" onclick="return confirmDelete()">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>