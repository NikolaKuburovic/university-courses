<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>

<h2>Измените информације о курсу</h2>

<form:form class="form-horizontal" item="${kurs}" method="POST" modelAttribute="kurs">
    <div class="form-group ${status.error ? 'has-error' : ''}">    
        <form:label class="col-sm-1 control-label" for="asId" path="asId">
            Асистент
        </form:label>
        <div class="col-sm-4">
            <form:select class="form-control" path="asId" placeholder="">
                <c:forEach var="asistent" items="${asistenti}">
                    <form:option value="${asistent.id}">
                        <c:out value="${asistent.ime}"/> <c:out value="${asistent.prezime}"/>
                    </form:option>  
                </c:forEach>
            </form:select>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}">    
        <form:label class="col-sm-1 control-label" for="prId" path="prId">
            Професор
        </form:label>
        <div class="col-sm-4">
            <form:select class="form-control" path="prId" placeholder="">
                <c:forEach var="profesor" items="${profesori}">
                    <form:option value="${profesor.id}">
                        <c:out value="${profesor.ime}"/> <c:out value="${profesor.prezime}"/>
                    </form:option>  
                </c:forEach>
            </form:select>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="naziv">
            Курс
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="naziv" placeholder=""/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="sifra">
            Шифра
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="sifra" placeholder=""/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="godina">
            Година
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="godina" placeholder=""/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="espb">
            ЕСПБ
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="espb" placeholder=""/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="opisKursa">
            Опис
        </form:label>
        <div class="col-sm-4">
            <form:textarea rows="8" class="form-control" path="opisKursa" placeholder=""/>
        </div>
    </div>
    <div class="form-group ${status.error ? 'has-error' : ''}"> 
        <form:label class="col-sm-1 control-label" path="cena">
            Цена (eur)
        </form:label>
        <div class="col-sm-4">
            <form:input class="form-control" path="cena" placeholder=""/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-4">

            <button type="submit" class="btn btn-primary pull-right">Унеси</button>

        </div>
    </div><br/>

</form:form>

<%@ include file="footer.jsp" %>

