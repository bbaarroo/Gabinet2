<%--
  Created by IntelliJ IDEA.
  User: bbi
  Date: 14.11.18
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Użytkownik</title>
    <%@include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/menu.jsp"%>


<h4>Dane użytkownika o id ${user.id}</h4>

<table border="2" class="table table-striped table-bordered table-hover">




    <tr>
        <td>ID</td>
        <td>${user.id}</td>
    </tr>

    <tr>
        <td>Imię</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>Nazwisko</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td>Pesel</td>
        <td>${user.pesel}</td>
    </tr>

    <tr>
        <td>Numer telefonu</td>
        <td>${user.phnoneNumber}</td>
    </tr>

    <tr>
        <td>Zalecenia</td>
        <td>${user.recommendation}</td>
    </tr>



    <tr>
        <td>Uwagi</td>
        <td>${user.comments}</td>
    </tr>


    <tr>
        <td>Data następnej wizyty</td>
        <td>${user.nextVisit}</td>
    </tr>

    <tr>
        <td>Suplementy</td>
        <td><c:forEach var="suplement" items="${suplements}">

            ${suplement.name}  <br>


        </c:forEach>
        </td>
    </tr>





</table><br>

<a href="/app/users/delete/${user.id}">Usuń użytkownika</a><br>
<a href="/app/users/update/${user.id}">Edytuj użytkownika</a><br>
<a href="/app/users/showall"${user.id}">Pokaż wszystkich użytkowników</a><br>
<a href="/app/users/toPdf/${user.id}">zapisz do pdf</a>
<%@include file="/WEB-INF/views/fragments/footer.jsp" %>
</body>
</html>
