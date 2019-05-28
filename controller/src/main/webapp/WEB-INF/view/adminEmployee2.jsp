<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>ADMIN page</title>
<style type="text/css">
table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<c:if test="${!empty error}">
		<h1 style="text-align: center; color: red">Error</h1>
		<p style="text-align: center">${error}</p>
	</c:if>

	<h1 style="color: red;">Detail Of ADMIN</h1>
	<div style="float: right">
		<form:form method="GET" action="login">
			<input type="submit" value="Logout">
		</form:form>
	</div>
  <div style="float:left">
  <form:form method="GET" action="">
	  <input type="radio" value=>SearchByName<br>
	  <input type="radio" value=>SearchById<br>
	  <input type="radio" value=>SearchByContact<br>
	  <input type="submit" value="Submit">
  </form:form>
  </div>

	<form:form method="POST" action="editinfo" modelAttribute="personDTO">
		<div>
			Id:<input readonly="true" name="id" value="${personDTO.id}" />
		</div>
		<div>
			First_Name:<input name="firstName" value="${personDTO.firstName}" />
		</div>
		<div>
			Country:<input name="country" value="${personDTO.country}" />
		</div>
		<div>
			UserName:<input name="username" value="${personDTO.username}" />
		</div>
		<div>
			Password:<input name="password" value="${personDTO.password}" />
		</div>
		<div>
			ADMIN:
			<td><select name="admin">
					<option value="yes">Yes</option>
					<option value="no">No</option>
			</select></td>
		</div>
		<div>
			Last_Name:<input name="lastName" value="${personDTO.lastName}" />
		</div>
		<div>
			Contact:<input name="contact" value="${personDTO.contact}" />
		</div>
		<div>
			<input name="adminId" type="hidden" value="${personDTO.id}" />
		</div>
		<input type="submit" value="EditAdmin">
	</form:form>
	<form:form method="GET" action="add?adminId=${personDTO.id}"
		modelAttribute="personDTO">
		<div>
			<input name="adminId" type="hidden" value="${personDTO.id}" />
		</div>
		<span><input type="submit" value="AddPerson"></span>

	</form:form>
	<h1 style="color: red;">List of PersonDTO</h1>
	<c:if test="${!empty listPersonDTO}">
		<table style="width: 50%">
			<tr>
				<th>ID</th>
				<th>First_Name</th>
				<th>Country</th>
				<th>UserName</th>
				<th>ADMIN</th>
				<th>Last_Name</th>
				<th>Contact</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${listPersonDTO}" var="personsDTO">
				<tr>
					<td>${personsDTO.id}</td>
					<td>${personsDTO.firstName}</td>
					<td>${personsDTO.country}</td>
					<td>${personsDTO.username}</td>
					<td>${personsDTO.admin}</td>
					<td>${personsDTO.lastName}</td>
					<td>${personsDTO.contact}</td>
					<td><a
						href="edit?userId=${personsDTO.id}&adminId=${personDTO.id}">Edit</a></td>
					<td><a
						href="remove?userId=${personsDTO.id}&adminId=${personDTO.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>