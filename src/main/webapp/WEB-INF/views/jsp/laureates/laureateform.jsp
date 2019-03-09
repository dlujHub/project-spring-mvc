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

    <c:choose>
        <c:when test="${laureateForm['new']}">
            <h1>Add Laureate</h1>
        </c:when>
        <c:otherwise>
            <h1>Update Laureate</h1>
        </c:otherwise>
    </c:choose>
    <br/>

    <spring:url value="/laureates" var="laureateActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="laureateForm" action="${laureateActionUrl}">

        <form:hidden path="id"/>

        <spring:bind path="first_name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">First Name</label>
                <div class="col-sm-10">
                    <form:input path="first_name" type="text" class="form-control" id="first_name"
                                placeholder="First Name"/>
                    <form:errors path="first_name" class="control-label"/>
                </div>
            </div>
        </spring:bind>


        <spring:bind path="last_name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Last Name</label>
                <div class="col-sm-10">
                    <form:input path="last_name" class="form-control" id="last_name" placeholder="Last Name"/>
                    <form:errors path="last_name" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="gender">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Gender</label>
                <div class="col-sm-10">
                    <label class="radio-inline"> <form:radiobutton path="gender" value="M"/> Male
                    </label> <label class="radio-inline"> <form:radiobutton path="gender" value="F"/> Female
                </label> <br/>
                    <form:errors path="gender" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="prize_year">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Prize year</label>
                <div class="col-sm-5">
                    <form:select path="prize_year" class="form-control">
                        <form:option value="" label="--- Select ---"/>
                        <form:options items="${yearList}"/>
                    </form:select>
                    <form:errors path="prize_year" class="control-label"/>
                </div>
                <div class="col-sm-5"></div>
            </div>
        </spring:bind>

        <spring:bind path="category">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Category</label>
                <div class="col-sm-5">
                    <form:select path="category" class="form-control">
                        <form:option value="" label="--- Select ---"/>
                        <form:options items="${categoryList}"/>
                    </form:select>
                    <form:errors path="category" class="control-label"/>
                </div>
                <div class="col-sm-5"></div>
            </div>
        </spring:bind>

        <spring:bind path="born">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Born</label>
                <div class="col-sm-5">
                    <form:input path="born" type="text" class="form-control" id="born"
                                placeholder="mm/dd/yyyy"/>
                    <form:errors path="born" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="died">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Died</label>
                <div class="col-sm-5">
                    <form:input path="died" type="text" class="form-control" id="died"
                                placeholder="mm/dd/yyyy or \"Alive\" or empty"/>
                    <form:errors path="died" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="born_country">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Born Country</label>
                <div class="col-sm-5">
                    <form:select path="born_country" class="form-control">
                        <form:option value="" label="--- Select ---"/>
                        <form:options items="${countryList}"/>

                    </form:select>
                    <form:errors path="born_country" class="control-label"/>
                </div>
                <div class="col-sm-5"></div>
            </div>
        </spring:bind>

        <spring:bind path="born_city">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Born City</label>
                <div class="col-sm-10">
                    <form:input path="born_city" class="form-control" id="born_city" placeholder="Born City"/>
                    <form:errors path="born_city" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="died_country">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Died Country</label>
                <div class="col-sm-5">
                    <form:select path="died_country" class="form-control">
                        <form:option value="" label="--- Select ---"/>
                        <form:options items="${countryList}"/>
                        <form:hidden path="died_country_code"/>
                    </form:select>
                    <form:errors path="died_country" class="control-label"/>
                </div>
                <div class="col-sm-5"></div>
            </div>
        </spring:bind>

        <spring:bind path="motivation">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Motivation</label>
                <div class="col-sm-10">
                    <form:textarea path="motivation" rows="5" class="form-control" id="address"
                                   placeholder="motivation"/>
                    <form:errors path="motivation" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${laureateForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

</div>

<jsp:include page="../parts/footer.jsp"/>

</body>
</html>