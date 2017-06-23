<%-- 
Document   : prikaz
Created on : Feb 11, 2017, 5:34:42 PM
Author     : Nikola Kuburovic
--%>

<%@ include file="header.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Spring MVC forma</title>
    </head>
    <body>
        <h2>Podaci o studentu</h2>
        <table>
            <tr>
                <td>Ime i prezime</td>
                <td>${ime}</td>
            </tr>
            <tr>
                <td>Godina</td>
                <td>${godina}</td>
            </tr>
            <tr>
                <td>Indeks</td>
                <td>${indeks}</td>
            </tr>
        </table>
    </body>
</html>
<%@ include file="footer.jsp" %>


