
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>


<h2>Асистенти</h2>
<c:if test="${!empty asistenti}">
    <table class="table table-hover">
        <tr>
            <th> ID</th>
            <th> Име</th>
            <th> Презиме</th>
            <th> Област</th>
            <th></th>
        </tr>
        <c:forEach items="${asistenti}" var="asistent">
            <tr>
                <td>${asistent.id}</td>
                <td>${asistent.ime}</td>
                <td>${asistent.prezime}</td>    
                <td>${asistent.oblast}</td>
                <td>
                    <spring:url value="/deleteAsistent/${asistent.id}" var="deleteUrl" />
                    <spring:url value="/editasistent/${asistent.id}" var="updateUrl" />

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

