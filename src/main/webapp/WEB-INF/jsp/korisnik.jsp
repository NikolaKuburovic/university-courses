<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<%--<% System.out.println("jsp: korisnici " + pageContext.findAttribute("korisnici"));%>--%>
<h2>Корисници:</h2>
<c:if test="${!empty korisnici}">
    <table class="table table-hover">
        <tr>
            <th> id</th>
            <th> Име</th>
            <th> Презиме</th>
            <th> Корисник</th>
            <th> Приступ</th>
            <th></th>
        </tr>
        <c:forEach items="${korisnici}" var="korisnik">
            <tr>
                <td>${korisnik.id}</td>
                <td>${korisnik.ime}</td>
                <td>${korisnik.prezime}</td>
                <td>${korisnik.username}</td>
                <td>${korisnik.enabled}</td>
                <td>

                    <spring:url value="/editkorisnik/${korisnik.id}" var="updateUrl" />
                    <spring:url value="/deletekorisnik/${korisnik.id}" var="deleteUrl" />

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