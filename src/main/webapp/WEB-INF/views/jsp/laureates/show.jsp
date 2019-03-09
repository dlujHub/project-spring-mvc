<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <h1>Info about ${laureate.first_name} ${laureate.last_name}</h1>
    <br/>

    <div class="row">
        <label class="col-sm-2">ID</label>
        <div class="col-sm-10">${laureate.id}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">First Name</label>
        <div class="col-sm-10">${laureate.first_name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Last Name</label>
        <div class="col-sm-10">${laureate.last_name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Gender</label>
        <div class="col-sm-10">${laureate.gender}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Prize year</label>
        <div class="col-sm-10">${laureate.prize_year}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Category</label>
        <div class="col-sm-10">${laureate.category}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Born</label>
        <div class="col-sm-10">${laureate.born}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Died</label>
        <div class="col-sm-10">${laureate.died}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Born country</label>
        <div class="col-sm-10">${laureate.born_country} [${laureate.born_country_code}]</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Born city</label>
        <div class="col-sm-10">${laureate.born_city}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Died country</label>
        <div class="col-sm-10">${laureate.died_country} [${laureate.died_country_code}]</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Motivation</label>
        <div class="col-sm-10">${laureate.motivation}</div>
    </div>

</div>

<jsp:include page="../parts/footer.jsp"/>

</body>
</html>