<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Customer</title>
</head>
<body>
<p:url value="/customer/add" var="addURL"/>
<a href="${addURL }">Add new Customer</a>
<table width="100%" border="1">
	<tr>
		<%--<td>ID</td>--%>
		<td>Firstname</td>
		<td>Lastname</td>
		<td>Gender</td>
		<td>Address</td>
		<td colspan="2">Actiond </td>
	</tr>
	<c:forEach items="${list }" var="customer">
		<tr>
			<%--<td>${customer.id}</td>--%>

			<td>${customer.firstname}</td>
			<td>${customer.lastname}</td>
			<td>${customer.gender}</td>
			<td>${customer.address}</td>
			<td>
				<p:url value="/customer/update/${customer.id}" var="updateURL"/>
				<a href="${updateURL}">Update</a>
			</td>
			<td>
				<p:url value="/customer/delete/${customer.id}" var="deleteURL"/>
				<a href="${deleteURL}">delete</a>
			</td>
		</tr>
	</c:forEach>


</table>

</body>
</html>