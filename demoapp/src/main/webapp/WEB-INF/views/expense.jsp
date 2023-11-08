<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense</title>
</head>
<body>

	<h1>Add Expense</h1>
	
	<form:hidden path="id"/>
	<form:form action="${contextRoot}/save" method ="post" modelAttribute="expense">
	<form:input path="expenseDscriptions" placeholder="Enter Expese Name"/>
	<form:input path="amount" placeholder="Enter Expese Amount"/>
	<form:textarea path="note" placeholder="Enter note(optional)"/>
	
	<button type="submit">Add Expense</button>
	</form:form >
</body>
</html>