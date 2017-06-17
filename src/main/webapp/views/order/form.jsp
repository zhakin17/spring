<%@include file="/views/head.jsp"%>
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
<spring:url value="/order/save" var="saveURL"/>
<form:form action="${saveURL }" method="POST" modelAttribute="orderForm">
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Customer</td>
			<td>
				<form:select path="customer.id">
					<form:options items="${customers}" itemValue="id" itemLabel="firstname" itemlabel="lastname"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Product</td>
			<td>
			<form:select path="product.id">
				<form:options items="${products}" itemValue="id" itemLabel="name" />
			</form:select>
			</td>
		</tr>
		<tr>
			<td>Date of Delivery</td>
			<td>
				<fmt:formatDate value="${bean.date}" pattern="yyyy-MM-dd HH:mm:ss" />
			 </td>
		</tr>
		<tr>
			<td>Date of Return</td>
			<td>
			<fmt:formatDate value="${bean.date}" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr>
			<td>Summa</td>
			<td>
					<form:input path="summa"/>
			</td>
		</tr>
		<tr>
			<td>Comission</td>
			<td>
				<form:input path="comission"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit">Save</button></td>
		</tr>
	</table>


</form:form>
<%@include file="/views/footer.jsp"%>