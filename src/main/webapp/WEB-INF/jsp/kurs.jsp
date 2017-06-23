<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%--<% System.out.println("jsp: kurs " + pageContext.findAttribute("kursevi"));%>--%>
<h2>Курсеви:</h2>
<c:if test="${!empty kursevi}">
    <table class="table table-hover">
        <tr>
            <th> id</th>
            <th> Шифра</th>
            <th> Асистент</th>
            <th> Професор</th>
            <th> Назив</th>
            <th> Година</th>
            <th> ЕСПБ</th>
            <th> Опис курса</th>
            <th> Цена курса</th>
            <th></th>
        </tr>
        <c:forEach items="${kursevi}" var="kurs">
            <tr>
                <td>${kurs.kursId}</td>
                <td>${kurs.sifra}</td>
                <td>${kurs.asistent.ime} ${kurs.asistent.prezime}</td>
                <td>${kurs.profesor.ime} ${kurs.profesor.prezime}</td>
                <td>${kurs.naziv}</td>
                <td>${kurs.godina}</td>
                <td>${kurs.espb}</td>
                <td>${kurs.opisKursa}</td>
                <td>${kurs.cena} eur</td>
                <td>


                    <spring:url value="/editkurs/${kurs.kursId}" var="updateUrl" />
                    <spring:url value="/deletekurs/${kurs.kursId}" var="deleteUrl" />

                    <button class="btn btn-info"
                            onclick="location.href = '${updateUrl}'">Измени</button>
                    <button class="btn btn-danger"
                            onclick="location.href = '${deleteUrl}'">Обриши</button>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<%@ include file="footer.jsp" %>