<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Luv2Code Company Home Page</title>
</head>

<body>
	<h2>Luv2Code Company Home Page</h2>
	<hr>

	<p>Welcome to luv2code company homePage</p>
	
	<!-- Add a Logout button -->
	
	<form:form action="${pageContext.request.contextPath}/logout"
			   method ="POST">
	  <input type="submit" value ="logout"/>
    </form:form>

</body>

</html>