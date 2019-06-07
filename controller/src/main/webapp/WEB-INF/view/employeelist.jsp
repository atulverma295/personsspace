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
	<c:if test="${!empty personDTOlist}">
		<table class="tg">
			<tr>
				<th>ID</th>
				<th>First_Name</th>
				<th>Country</th>
				<th>UserName</th>
				<th>PassWord</th>
				<th>ADMIN</th>
				<th>Lasst_Name</th>
				<th>Contact</th>
			</tr>
			<c:forEach items="${personDTOlist}" var="personDTO">
				<tr>
					<td>${personDTO.id}</td>
					<td>${personDTO.firstName}</td>
					<td>${personDTO.country}</td>
					<td>${personDTO.username}</td>
					<td>${personDTO.password}</td>
					<td>${personDTO.admin}</td>
					<td>${personDTO.lastName}</td>
					<td>${personDTO.contact}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
