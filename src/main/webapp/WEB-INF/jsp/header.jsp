
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
              crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-2.2.3.js" integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
        <spring:url value="/resources/css/stil.css" var="stilCss"></spring:url>
        <link href="${stilCss}" rel="stylesheet" />

        <title>MetCourses</title>

    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myNavbar" aria-expanded="false"
                                aria-controls="navbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/MetCourses">MetCourses</a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li><a href="/MetCourses">Почетна</a></li>
                            <li><a href="/MetCourses/admin">Админ</a></li>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li class="dropdown">
                                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                                        Професори <b class="caret"></b></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="/MetCourses/profesor">Табела професора</a></li>
                                        <li><a href="/MetCourses/addprofesor">Унос професора</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                                        Асистенти <b class="caret"></b></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="/MetCourses/asistent">Табела асистената</a></li>
                                        <li><a href="/MetCourses/addasistent">Унос асистената</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                                        Корисници <b class="caret"></b></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="/MetCourses/korisnik">Табела корисника</a></li>
                                        <li><a href="/MetCourses/addkorisnik">Унос корисника</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                                        Курсеви <b class="caret"></b></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="/MetCourses/kurs">Табела курсева</a></li>
                                        <li><a href="/MetCourses/addkurs">Унос курсева</a></li>
                                    </ul>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="isAnonymous()">
                                <li><a href="/MetCourses/login"><span class="glyphicon glyphicon-log-in"></span> Пријавите се</a></li>
                                <li><a href="/MetCourses/addkorisnik"><span class="glyphicon glyphicon-user"></span> Региструјте се</a></li>
                                </sec:authorize>
                            <li>
                                <sec:authorize access="hasRole('ROLE_USER')">
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
                                        <a href="#" onclick="formSubmit();
                                                return false;">Одјавите се</a>
                                    </c:if>
                                </sec:authorize>
                            </li>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">


                                <sec:authorize access="!hasRole('ROLE_ADMIN')">
                                    <li><a href="<c:url value="/korpa" />"><span class="glyphicon glyphicon-shopping-cart"></span> Корпа</a></li>
                                    </sec:authorize>

                                <li><a><span class="glyphicon glyphicon-user"></span> ${pageContext.request.userPrincipal.name}</a></li>

                            </c:if>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="omot">