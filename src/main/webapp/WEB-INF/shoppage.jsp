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


            <h2>Welcome to the shop!</h2>
            <h3>Create your cupcake</h3> <br>

            <form method="post" >

                <p>Choose your base:</p>
                <input type="radio" id="Chocolate" name="bottom" value="Chocolate">
                <label for="Chocolate"> Chocolate</label><br>
                <input type="radio" id="Vanilla" name="bottom" value="Vanilla">
                <label for="Vanilla"> Vanilla</label><br>
                <input type="radio" id="Nutmeg" name="bottom" value="Nutmeg">
                <label for="Nutmeg"> Nutmeg</label><br><br>


                <p>Choose your topping:</p>
                <input type="radio" id="Chocolate_top" name="topping" value="Chocolate">
                <label for="Chocolate_top"> Chocolate</label><br>
                <input type="radio" id="Blueberry_top" name="topping" value="Blueberry">
                <label for="Blueberry_top"> Blueberry</label><br>
                <input type="radio" id="Raspberry_top" name="topping" value="Raspberry">
                <label for="Raspberry_top"> Raspberry</label><br>

                <input id="amount"  name="amount" type="number"/>
                <label for="amount">How many do you want?</label> <br> <br>

                <button type="submit">add to cart</button>

            </form>

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