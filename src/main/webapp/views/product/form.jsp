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
<spring:url value="/product/save" var="saveURL"/>
<form:form action="${saveURL}" method="POST" modelAttribute="productForm">
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Name</td>
			<td><form:input path="name"/> </td>
		</tr>
		<tr>
			<td>Decription</td>
			<td><form:input path="decription"/> </td>
		</tr>
		<tr>
			<td>CategoryCredits</td>
			<td>
				<form:select path="categoryCredit.id">
					<form:options itemValue="id" items="${categoryCredits}" itemLabel="name"/>
				</form:select>
			 </td>
		</tr>
		<tr>
			<td>categoryProduct</td>
			<td>
			<form:select path="categoryProduct.id">
				<form:options itemValue="id" items="${categoryProducts}" itemLabel="name"/>
			</form:select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><form:button type="submit">Save</form:button></td>
		</tr>
	</table>


</form:form>
<%@include file="/views/footer.jsp"%>