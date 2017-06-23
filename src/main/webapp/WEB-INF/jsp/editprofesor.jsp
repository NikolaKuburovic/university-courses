<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>

<h2>Измените информације о професору</h2>

<form:form class="form-horizontal" item="${profesor}" method="POST" modelAttribute="profesor">
    <div class="form-group ${status.error ? 'has-error' : ''}">    
        <form:label class="col-sm-1 control-label" path="ime">
            <spring:message code="name"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="ime" placeholder="${profesor.ime}"/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}">  
        <form:label class="col-sm-1 control-label" path="prezime">
            <spring:message code="surname"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="prezime" placeholder="${profesor.prezime}"/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="oblast">
            <spring:message code="field"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="oblast" placeholder="${profesor.oblast}"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-4">

            <button type="submit" class="btn-lg btn-primary pull-right">Измени</button>

        </div>
    </div><br/>

</form:form>

<%@ include file="footer.jsp" %>