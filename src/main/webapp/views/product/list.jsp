<%@include file="/views/head.jsp"%>
<p:url value="/product/add" var="addURL"/>
<a href="${addURL }">Add new Product</a>
<table width="100%" border="1">
	<tr>
		<%--<td>ID</td>--%>
		<td>name</td>
		<td>Description</td>
		<td>CategoryCredit</td>
		<td>CategoryProduct</td>
		<td colspan="2">Actiond </td>
	</tr>
	<c:forEach items="${list}" var="product">
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

<%@include file="/views/footer.jsp"%>