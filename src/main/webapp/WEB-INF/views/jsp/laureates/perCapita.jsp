<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../parts/header.jsp"/>

<body>

<div class="container">

    <h1> Laureates per capita </h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Country</th>
            <th>Nobel Laureates</th>
            <th>Population</th>
            <th>Laureates/10 million</th>
        </tr>
        </thead>

        <c:forEach var="country" items="${countries}">
            <tr>
                <td style="text-align:center">${country.name}</td>
                <td style="text-align:center">${country.nrOfNobelLaureates}</td>
                <td style="text-align:center">${country.population}</td>
                <td style="text-align:center">${country.laureatesPer10Mln}</td>

            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../parts/footer.jsp"/>

</body>
</html>