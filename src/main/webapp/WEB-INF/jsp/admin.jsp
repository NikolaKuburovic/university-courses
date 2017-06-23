
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>

<h2>Здраво, админе!</h2>
<h2> ${message}</h2>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" 
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Корисничко име је:
        ${pageContext.request.userPrincipal.name} | 
        <a href="javascript:formSubmit()"> Одјави се</a>
    </h2>
</c:if>

<%@ include file="footer.jsp" %>
