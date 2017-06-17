<%@include file="/views/head.jsp"%>
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