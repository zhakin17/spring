<%@include file="/views/head.jsp"%>
<p:url value="/order/add" var="addURL"/>
<a href="${addURL }">Add new Order</a>
<table width="100%" border="1">
	<tr>
		<%--<td>ID</td>--%>
		<td>Order Number</td>
		<td>Customer</td>
		<td>Product</td>
		<td>Date of Delivery</td>
		<td>Date of Return</td>
		<td>Summa</td>
		<td>Comission</td>
		<td colspan="2">Actiond </td>
	</tr>
	<c:forEach items="${list}" var="order">
		<tr>
			<%--<td>${customer.id}</td>--%>

			<td>${order.orderNumber}</td>
			<td>${order.customer.firstname} </td>
			<td>${order.product.name}</td>
			<td>${order.dateOfDelivery}</td>
			<td>${order.dateOfDelivery}</td>
			<td>${order.dateOfReturn}</td>
			<td>${order.summa}</td>
			<td>${order.comission}</td>
			<td>
				<p:url value="/order/update/${order.id}" var="updateURL"/>
				<a href="${updateURL}">Update</a>
			</td>
			<td>
				<p:url value="/order/delete/${order.id}" var="deleteURL"/>
				<a href="${deleteURL}">delete</a>
			</td>
		</tr>
	</c:forEach>


</table>

<%@include file="/views/footer.jsp"%>