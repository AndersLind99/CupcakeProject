<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
        Shop
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>


            <h2>Basket</h2>
            <h3>here is everything in ur basket</h3> <br>


            <div>

                <h3>Basket</h3><br>


                <table class="table table-striped">
                    <thead>
                    <th>base</th>
                    <th>Topping</th>
                    <th>amount</th>
                    <th>Price</th>
                    </thead>
                    <c:forEach var="basketItem" items="${sessionScope.basket.basketItemList}">
                        <tr>
                            <td>${basketItem.base.name}</td>
                            <td>${basketItem.topping.name}</td>
                            <td>${basketItem.amount}</td>
                            <td>${basketItem.price} kr</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>Total Price:</td>
                        <td>${sessionScope.basket.totalSum()}kr</td>
                    </tr>


                </table>


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