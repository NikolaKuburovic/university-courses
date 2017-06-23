<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="header.jsp" %>

<h2>Потврда регистрације</h2>
<div class="alert alert-success lead">
    <strong>Успешно!</strong> ${success}
</div>


<button class="btn btn-info"
        onclick="location.href = '/MetCourses/addasistent'">Додај следећег асистента</button>
<button class="btn btn-danger"
        onclick="location.href = '/MetCourses/asistent'">Погледај листу асистената</button>


<%@ include file="footer.jsp" %>