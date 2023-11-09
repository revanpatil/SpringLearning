<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Luv2Code Company Home Page</title>
</head>

<body>
	<h2>Luv2Code Company Home Page</h2>
	<hr>

	<p>Welcome to luv2code company homePage</p>

	<!-- Display username and user roles -->

	<hr>

	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> UserRole :
		<security:authentication property="principal.authorities" />

	</p>

	<hr>

	<!-- Add a Link to point out to leaders only for Managers-->
	<security:authorize access="hasRole('Manager')">
		<a href="${pageContext.request.contextPath}/leaders"> Leadership
			Meeting </a> (Only for Managers )
	</security:authorize>


	<hr>

	<!-- Add a Link to point out to leaders only for admins-->
	<security:authorize access="hasRole('Admin')">
		<a href="${pageContext.request.contextPath}/systems"> Leadership
			Meeting </a> (Only for Admin )
	 </security:authorize>


	<hr>
	<!-- Add a Logout button -->

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="logout" />
	</form:form>



</body>

</html>