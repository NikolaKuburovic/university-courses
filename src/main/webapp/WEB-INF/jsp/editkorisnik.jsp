<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>

<h2>Измените информације о кориснику</h2>

<form:form class="form-horizontal" item="${korisnik}" method="POST" modelAttribute="korisnik">
    <div class="form-group ${status.error ? 'has-error' : ''}">    
        <form:label class="col-sm-1 control-label" path="ime">
            <spring:message code="name"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="ime" placeholder="${korisnik.ime}"/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}">  
        <form:label class="col-sm-1 control-label" path="prezime">
            <spring:message code="surname"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="prezime" placeholder="${korisnik.prezime}"/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="username">
            <spring:message code="username"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="username" placeholder="${korisnik.username}"/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="password">
            <spring:message code="password"/>
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="password" placeholder="${korisnik.password}"/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="enabled">
            <spring:message code="enabled"/>
        </form:label>
        <div class="col-sm-4">
            <form:select path="enabled">
                <form:option value="1" label="Да" />
                <form:option value="0" label="Не" />
            </form:select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-4">

            <button type="submit" class="btn-lg btn-primary pull-right">Измени</button>

        </div>
    </div><br/>

</form:form>

<%@ include file="footer.jsp" %>