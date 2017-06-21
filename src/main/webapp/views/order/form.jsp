<%@include file="/views/head.jsp"%>

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
					<div >
						<form:input path="dateOfDelivery" type="date"/>

					</div>
			 </td>
		</tr>
		<tr>
			<td>Date of Return</td>
			<td>
				<form:input path="dateOfReturn" type="date"/>
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