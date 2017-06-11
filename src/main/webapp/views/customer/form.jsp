<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="p" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
<p:url value="/customer/save" var="saveURL"></p:url>
<form action="${saveURL }" method="POST" modelAttribute="customer/form">
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Firstname</td>
			<td><form:input path="firsname"/> </td>
		</tr>
		<tr>
			<td>Lastname</td>
			<td><form:input path="lastname"/> </td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
			<form:radiobutton path="gender" value="male"/>
			<form:radiobutton path="gender" value="Female"/>
			 </td>
		</tr>
		<tr>
			<td>Address</td>
			<td><form:textarea path="address" rows="3"/> </td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit">Save</button></td>
		</tr>
	</table>


</form>
</body>
</html>