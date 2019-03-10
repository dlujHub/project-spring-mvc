<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
    <hr>
    <footer>
        <div style="text-align: center;"><p> Spring MVC PROJECT 2018 </p></div>
    </footer>
</div>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/core/js/hello.js" var="mainJs"/>
<spring:url value="/resources/core/js/bootstrap.min.js"
            var="bootJs"/>

<script src="${mainJs}"></script>
<script src="${bootJs}"></script>


