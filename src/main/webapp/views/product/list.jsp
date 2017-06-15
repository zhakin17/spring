<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Customer</title>
</head>
<body>
<p:url value="/product/add" var="addURL"/>
<a href="${addURL }">Add new Customer</a>
<table width="100%" border="1">
	<tr>
		<%--<td>ID</td>--%>
		<td>name</td>
		<td>Description</td>
		<td>CategoryCredit</td>
		<td>CategoryProduct</td>
		<td colspan="2">Actiond </td>
	</tr>
	<c:forEach items="${list }" var="product">
		<tr>
			<%--<td>${customer.id}</td>--%>

			<td>${product.name}</td>
			<td>${product.decription}</td>
			<td>${product.categoryCredit.name}</td>
			<td>${product.categoryProduct.name}</td>
			<td>
				<p:url value="/product/update/${product.id}" var="updateURL"/>
				<a href="${updateURL}">Update</a>
			</td>
			<td>
				<p:url value="/product/delete/${product.id}" var="deleteURL"/>
				<a href="${deleteURL}">delete</a>
			</td>
		</tr>
	</c:forEach>


</table>

</body>
</html>