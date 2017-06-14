<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
<spring:url value="/categoryProduct/save" var="saveURL"/>
<form:form action="${saveURL }" method="POST" modelAttribute="categoryProductForm">
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Firstname</td>
			<td><form:input path="name"/> </td>
		</tr>


		<tr>
			<td></td>
			<td><button type="submit">Save</button></td>
		</tr>
	</table>


</form:form>
</body>
</html>