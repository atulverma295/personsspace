<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>EmployeePage</title>
<style type="text/css">
table,th,td {
	border: 2px solid black;
	border-collapse:collapse;
}
</style>
</head>
<body>
	<h1 style="color: red;">Detail of Employee</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>First_Name</th>
			<th>Country</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Last_Name</th>
			<th>Contact</th>
		</tr>
		<tr>
			<c:if test="${not empty personDTO}">
				<td>${personDTO.id}</td>
				<td>${personDTO.firstName}</td>
				<td>${personDTO.country}</td> 
				<td>${personDTO.username}</td>
				<td>${personDTO.password}</td>
				<td>${personDTO.lastName}</td>
				<td>${personDTO.contact}</td>
				
			</c:if>
		</tr>
	</table>
</body>
</html>
