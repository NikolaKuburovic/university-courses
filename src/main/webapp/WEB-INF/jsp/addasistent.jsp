
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>

<h2>Унесите информације о асистенту</h2>

<form:form class="form-horizontal" method="POST" modelAttribute="asistent">
    <div class="form-group ${status.error ? 'has-error' : ''}">    
        <form:label class="col-sm-1 control-label" path="ime">
            <spring:message code="name"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="ime" placeholder=""/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}">  
        <form:label class="col-sm-1 control-label" path="prezime">
            <spring:message code="surname"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="prezime" placeholder=""/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="oblast">
            <spring:message code="field"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="oblast" placeholder=""/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-4">

            <button type="submit" class="btn btn-primary pull-right">Унеси</button>

        </div>
    </div><br/>

</form:form>

<%@ include file="footer.jsp" %>

