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

            <div>
                <form method="post" action="basketpage">

                    <div class="row">
                        <div class="col">
                            <div class="form-group">
                                <label class="form-check-label" for="bases">Bases:</label>
                                <select class="form-control" name="bases" id="bases">
                                    <c:forEach var="bases" items="${applicationScope.basesList}">
                                        <option value="${bases.bases_id}">${bases.name}(${bases.price} kr.)</option>
                                    </c:forEach>
                                </select>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <div class="form-group">
                                <label class="form-check-label" for="toppings">Toppings:</label>
                                <select class="form-control" name="toppings" id="toppings">
                                    <c:forEach var="toppings" items="${applicationScope.toppingsList}">
                                        <option value="${toppings.toppings_id}">${toppings.name}(${toppings.price}
                                            kr.)
                                        </option>
                                    </c:forEach>
                                </select>

                            </div>
                        </div>
                    </div>

                    <input id="amount" name="amount" type="number" value="0"/>
                    <label for="amount">How many do you want?</label> <br> <br>

                    <button type="submit">add to cart</button>

                </form>
            </div>


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