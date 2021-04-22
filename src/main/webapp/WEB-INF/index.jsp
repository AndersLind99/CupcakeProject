<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
        Frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
        <c:set var="addOrderLink" value="${false}" scope="request"/>
        <c:set var="addProfileLink" value="${false}" scope="request"/>
        <c:set var="addAboutLink" value="${false}" scope="request"/>
        <c:set var="addBasketLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>Welcome to Olsker Cupcakes</h2>

            <p>
                here is a link to the shop:
                <a href=fc/shoppage>Shop</a>

            </p>

            <div style="margin-top: 3em;margin-bottom: 3em;">
                Home to the best cupcakes on the island. <br/>
                Mums Filibaba.
            </div>

            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>