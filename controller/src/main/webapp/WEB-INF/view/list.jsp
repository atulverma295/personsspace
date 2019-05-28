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
	<h1 style="color: red;">EmployeeList</h1>
	<c:if test="${!empty personDTO}">
		<table class="tg">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Country</th>
				<th>UserName</th>
				<th>PassWord</th>
				<th>ADMIN</th>
				<th>Contact</th>
			</tr>
			<c:forEach items="${personDTO}" var="persons">
				<tr>
					<td>${persons.id}</td>
					<td>${persons.name}</td>
					<td>${persons.country}</td>
					<td>${persons.username}</td>
					<td>${persons.password}</td>
					<td>${persons.admin}</td>
					<td>${persons.contact}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
