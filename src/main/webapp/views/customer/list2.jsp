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
		<td>ID</td>
	</tr>
	<c:forEach items="${list}" var="customer">
	<tr>
		<td>${customer}</td>
	</tr>
	</c:forEach>
	

</table>

</body>
</html>