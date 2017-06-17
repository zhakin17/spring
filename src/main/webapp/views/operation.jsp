<%--
  Created by IntelliJ IDEA.
  User: samatzhakin
  Date: 17.06.17
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<p:url value="/product/add" var="addProduct"/>
<p:url value="/customer/add" var="addCustomer"/>
<p:url value="/categoryProduct/add" var="categoryProduct"/>
<p:url value="/categoryCredit/add" var="categoryCredit"/>
<ul>
    <li>
        <a href="${addProduct}">Add new Product</a>
    </li>
    <li>
        <a href="${addCustomer}">Add new Customer</a>
    </li>
    <li>
        <a href="${categoryProduct}">Add new categoryProduct</a>
    </li>
    <li>
        <a href="${categoryCredit}">Add new categoryCredit</a>
    </li>
</ul>



<%@include file="footer.jsp"%>
</body>
</html>
