<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../parts/header.jsp"/>

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>List of Nobel laureates</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Prize year</th>
            <th>Category</th>
            <th>Born</th>
            <th>Died</th>
            <th>Born country, city</th>
            <th>Died country</th>
            <th>Motivation</th>
        </tr>
        </thead>

        <c:forEach var="country" items="${laureates}">
            <tr>
                <td style="text-align:center">${country.first_name} ${country.last_name}</td>
                <td style="text-align:center">${country.gender}</td>
                <td style="text-align:center">${country.prize_year}</td>
                <td style="text-align:center">${country.category}</td>
                <td style="text-align:center">${country.born}</td>
                <td style="text-align:center">${country.died}</td>
                <td style="text-align:center">${country.born_country}, ${country.born_city}</td>
                <td style="text-align:center">${country.died_country}</td>
                <td>${country.motivation}</td>
                <td>
                    <spring:url value="/laureates/${country.id}" var="laureateUrl"/>
                    <spring:url value="/laureates/${country.id}/delete" var="deleteUrl"/>
                    <spring:url value="/laureates/${country.id}/update" var="updateUrl"/>

                    <div style="text-align: center;">
                        <button class="btn btn-info" onclick="location.href='${laureateUrl}'">More..</button>
                    </div>
                    <div style="text-align: center;">
                        <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit...</button>
                    </div>
                    <div style="text-align: center;">
                        <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../parts/footer.jsp"/>

</body>
</html>