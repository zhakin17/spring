<%--
  Created by IntelliJ IDEA.
  User: samatzhakin
  Date: 17.06.17
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<p:url value="/customer/list" var="listCustomer"/>
<p:url value="/product/list" var="listProduct"/>
<p:url value="/categoryProduct/list" var="listcategoryProduct"/>
<p:url value="/categoryCredit/list" var="listcategoryCredit"/>
<p:url value="/order/list" var="listOrders"/>
<ul>
    <li>
        <a href="${listCustomer }">ListCustomer</a>
    </li>
    <li>
        <a href="${listProduct}">List Product</a>
    </li>
    <li>
        <a href="${listcategoryProduct}">List Category Product</a>
    </li>
    <li>
        <a href="${listcategoryCredit}">List Category Credit</a>
    </li>
    <li>
        <a href="${listOrders}"> List Orders</a>
    </li>
</ul>

<%@include file="footer.jsp"%>
