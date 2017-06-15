<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form</title>
</head>
<body>
<spring:url value="/categoryCredit/save" var="saveURL"/>
<form:form action="${saveURL }" method="POST" modelAttribute="categoryCreditForm">
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>name</td>
			<td><form:input path="name"/> </td>
		</tr>
		<tr>
			<td>price</td>
			<td><form:input path="price"/> </td>
		</tr>

		<tr>
			<td></td>
			<td><button type="submit">Save</button></td>
		</tr>
	</table>


</form:form>
</body>
</html>