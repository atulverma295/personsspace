<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Person Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}


.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Add a Person</h1>
	<c:if test="${!empty error}">
		<h1 style="text-align: center; color: red">Error</h1>
		<p style="text-align: center">${error}</p>
	</c:if>

	<form:form method="POST" action="/controller/addperson"
		modelAttribute="userDTO">
		<table>
			<c:if test="${not empty userDTO.firstName}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="firstName">
						<spring:message text="FirstName" />
					</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="country">
						<spring:message text="Country" />
					</form:label></td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td><form:label path="username">
						<spring:message text="Username" />
					</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="admin">
						<spring:message text="Admin" />
					</form:label></td>
				<td><select name="admin">
						<option value="yes">Yes</option>
						<option value="no">No</option>
				</select></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message text="LastName" />
					</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="contact">
						<spring:message text="Contact" />
					</form:label></td>
				<td><form:input path="contact" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:hidden path="adminId" /></td>
			</tr>
			<tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Person" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
