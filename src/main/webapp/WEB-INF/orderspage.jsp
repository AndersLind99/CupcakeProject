<%--
  Created by IntelliJ IDEA.
  User: Lukas
  Date: 20-04-2021
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage>
    <jsp:attribute name="header">
         Place a new Order
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div style="margin-top: 5em;">
        <form name="order" action="${pageContext.request.contextPath}/fc/orderpage" method="POST"></form>


        <html>
        <head>
        <title>Hello</title>
        </head>
        <body>
        </body>
        </html>

        </div>
    </jsp:body>
</t:genericpage>