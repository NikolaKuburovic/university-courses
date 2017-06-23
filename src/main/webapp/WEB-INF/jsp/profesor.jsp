
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>


<h2>Професори</h2>
<c:if test="${!empty profesori}">
    <table class="table table-hover">
        <tr>
            <th> ID</th>
            <th> Име</th>
            <th> Презиме</th>
            <th> Област</th>
            <th></th>
        </tr>
        <c:forEach items="${profesori}" var="profesor">
            <tr>
                <td>${profesor.id}</td>
                <td>${profesor.ime}</td>
                <td>${profesor.prezime}</td>    
                <td>${profesor.oblast}</td>
                <td>

                    <spring:url value="/deleteProfesor/${profesor.id}" var="deleteUrl" />
                    <spring:url value="/editprofesor/${profesor.id}" var="updateUrl" />

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

