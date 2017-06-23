<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>

<h2>Ваша корпа</h2>

<div>

    <c:if test="${not empty error}"><div class="alert-box error"><span style="font-weight: bold; color: red;">Error: </span>${error}</div></c:if>
    <a href="${pageContext.request.contextPath}/korpa/potvrdikupovinu" class="btn btn-success pull-right"><span class="glyphicon glyphicon-ok"></span> Потврђујем куповину</a>
</div>
<table class="table table-hover">
    <tr>

        <th> Шифра</th>
        <th> Назив</th>
        <th> Цена</th>
        <th> Количина</th>
        <th> Износ</th>
        <th></th>
    </tr>
    <c:set var="ukupno" value="0"></c:set>
    <c:forEach items="${sessionScope.korpa}" var="stavka">
        <c:set var="ukupno" value="${ukupno + stavka.kurs.cena * stavka.kolicina}"></c:set>
            <tr>
                <td>${stavka.kurs.sifra}</td>
            <td>${stavka.kurs.naziv}</td>
            <td>${stavka.kurs.cena} eur</td>
            <td>${stavka.kolicina}</td>
            <td>${stavka.kurs.cena * stavka.kolicina} eur</td>
            <td>
                <spring:url value="/editkurs/${kurs.kursId}" var="updateUrl" />
                <spring:url value="/deletekurs/${kurs.kursId}" var="deleteUrl" />
                <a href="${pageContext.request.contextPath}/korpa/obrisi/${stavka.kurs.sifra}" class="btn btn-danger btn-large"><span class="glyphicon glyphicon-remove"></span> Уклони</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>Укупно</td>
        <td>${ukupno} eur</td>
    </tr>
</table>
<br />
<a href="${pageContext.request.contextPath}" class="btn btn-warning btn-large"><span class="glyphicon glyphicon-shopping-cart"></span> Настави куповину</a>

<%@ include file="footer.jsp" %>