<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CategoryProduct</title>
</head>
<body>
<p:url value="/categoryCredit/add" var="addURL"/>
<a href="${addURL }">Add new Customer</a>
<table width="100%" border="1">
	<tr>
		<td>name</td>
		<td>price</td>
		<td colspan="2">Actiond </td>
	</tr>
	<c:forEach items="${list }" var="categoryCredit">
		<tr>
			<td>${categoryCredit.name}</td>
			<td>${categoryCredit.price}</td>

			<td>
				<p:url value="/categoryCredit/update/${categoryProduct.id}" var="updateURL"/>
				<a href="${updateURL}">Update</a>
			</td>
			<td>
				<p:url value="/categoryCredit/delete/${categoryProduct.id}" var="deleteURL"/>
				<a href="${deleteURL}">delete</a>
			</td>
		</tr>
	</c:forEach>


</table>

</body>
</html>