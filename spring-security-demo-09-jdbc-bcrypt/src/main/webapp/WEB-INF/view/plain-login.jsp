<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
	<title>Custom login Page</title>

		<style>
			.failed {
				color: red
				}
		</style>
</head>

<body>
	<h3>My Custom Login Page</h3>


	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<!-- Check for Login Error  -->

		<c:if test="${param.error!=null }">

			<i class="failed"> Sorry! You have entered incorrect Details</i>
		</c:if>

		<p>
			UserName : <input type="text" name="username">
		</p>

		<p>
			Password : <input type="password" name="password">
		</p>

		<input type="submit" value="Login" />
	</form:form>
</body>
</html>
