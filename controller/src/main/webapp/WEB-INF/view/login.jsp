<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
</head>
<body>
	<h2>Login Page</h2>
	<c:if test="${!empty error}">
		<h1 style="text-align: center; color: red">Error</h1>
		<p style="text-align: center">${error}</p>
	</c:if>
	<form:form method="POST" action="loginUser" modelAttribute="loginDTO">
		<table>
			<tr>
				<td><form:label path="username">UserName</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">PassWord</form:label></td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>