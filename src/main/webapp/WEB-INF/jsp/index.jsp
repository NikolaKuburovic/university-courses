<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp" %>

<%--<% System.out.println("jsp: kurs " + pageContext.findAttribute("kursevi"));%>--%>
<br/>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="<c:url value="/slike/slika1.jpg" />" alt="MetCourses1">
        </div>

        <div class="item">
            <img src="<c:url value="/slike/slika2.jpg" />" alt="MetCourses2">
        </div>

        <div class="item">
            <img src="<c:url value="/slike/slika3.jpg" />" alt="MetCourses3">
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Претходно</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Следеће</span>
    </a>
</div>
<br />
<div class="omot">

    <br />

    <div class="row">
        <c:forEach items="${kursevi}" var="kurs">
            <div class="col-md-4">

                <div id="home${kurs.sifra}" class="tab-pane fade in active">

                    <img src="<c:url value="/slike/${kurs.sifra}.jpg" />" /><br />
                    <h4>${kurs.naziv}</h4>
                    <p>Шифрa: ${kurs.sifra}</p>
                    <p>Професор: ${kurs.profesor.ime} ${kurs.profesor.prezime}</p>
                    <p>Асистент: ${kurs.asistent.ime} ${kurs.asistent.prezime}</p>
                    <p>Година: ${kurs.godina}</p>
                    <p>ЕСПБ: ${kurs.espb}</p>

                </div>

                <div id="menu1${kurs.sifra}" class="tab-pane fade" style="position:absolute">
                    <h5 id="opisnaslov">${kurs.naziv}</h5>
                    <p id="opis">${kurs.opisKursa}</p>

                </div>
                <div id="menu2${kurs.sifra}" class="tab-pane fade" style="position:absolute">
                    <h5 id="opisnaslov">${kurs.naziv}</h5>
                    <p id="opis" style="text-align: center">За овај курс доступан вам је бесплатан текстуални материјал предавања.</p>
                    </br>
                    <ul>
                        <li style="color:#3AB2D6; font-size: 24px;" class="glyphicon glyphicon-cd large"></li>
                        <li style="list-style-type: none; font-weight: bold">Комплетан курс који садржи:</li>
                        <li>видео предавања</li>
                        <li>текстуална предавања</li>
                        <li>вежбе за свако предавање</li>
                        <li>додатни материјал</li>
                        <li>тестове за проверу знања</li>
                        </br>
                        <li style="list-style-type: none">можете купити по цени од</li>
                    </ul>
                    <h5 id="opisnaslov">${kurs.cena} eur</h5>

                    <a href="${pageContext.request.contextPath}/materijal/${kurs.sifra}.pdf" class="btn btn-info btn-large"><span class="glyphicon glyphicon-download-alt"></span> Преузми ПДФ</a>
                    <a href="${pageContext.request.contextPath}/korpa/kupikurs/${kurs.sifra}" class="btn btn-warning btn-large"><span class="glyphicon glyphicon-shopping-cart"></span> Купи курс</a>
                </div>
                <ul class="nav nav-tabs">

                    <li class="active"><a data-toggle="tab" href="#home${kurs.sifra}">Курс</a></li>
                    <li><a data-toggle="tab" href="#menu1${kurs.sifra}">Детаљи</a></li>
                        <sec:authorize access="isAuthenticated()">
                        <li><a data-toggle="tab" href="#menu2${kurs.sifra}">Материјал</a></li>
                        </sec:authorize>
                </ul>
            </div>
        </c:forEach>
    </div>
</div>

<%@ include file="footer.jsp" %>