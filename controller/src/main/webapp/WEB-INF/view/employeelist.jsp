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
			<c:forEach items="${personDTOlist}" var="persons">
				<tr>
					<td>${persons.id}</td>
					<td>${persons.first_name}</td>
					<td>${persons.country}</td>
					<td>${persons.username}</td>
					<td>${persons.password}</td>
					<td>${persons.admin}</td>
					<td>${persons.last_name}</td>
					<td>${persons.contact}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${!empty listPersonDTO}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">First_Name</th>
		<th width="120">Country</th>
		<th width="120">UserName</th>
		<th width="120">PassWord</th>
		<th width="120">ADMIN</th>
		<th width="120">Last_Name</th>
		<th width="120">Contact</th>
		
	</tr>
	<c:forEach items="${listPersonDTO}" var="person">
		<tr>
			<td>${person.id}</td>
			<td>${person.first_name}</td>
			<td>${person.country}</td>
			<td>${person.username}</td>
			<td>${person.password}</td>
			<td>${person.admin}</td>
			<td>${person.last_name}</td>
			<td>${person.contact}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
