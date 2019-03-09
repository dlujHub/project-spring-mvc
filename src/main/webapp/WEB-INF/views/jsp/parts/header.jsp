<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <title>List of Nobel Laureates</title>

    <spring:url value="/resources/core/css/hello.css" var="mainCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootCss"/>

    <link href="${bootCss}" rel="stylesheet"/>
    <link href="${mainCss}" rel="stylesheet"/>
</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/laureates/add" var="urlAddLaureate"/>
<spring:url value="/laureates_per_capita" var="urlPerCapita"/>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">List of Nobel Laureates</a>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlPerCapita}">Laureates per capita</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlAddLaureate}">Add Laureate</a></li>
            </ul>
        </div>
    </div>
</nav>