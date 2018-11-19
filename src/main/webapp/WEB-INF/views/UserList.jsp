<%--
  Created by IntelliJ IDEA.
  User: bbi
  Date: 13.11.18
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista użytkowników</title>
    <%@include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/menu.jsp"%>

<h1>Lista użytkowników</h1>

<table border="2" class="table table-striped table-bordered table-hover">

    <thead>
    <tr>
        <th>id</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Akcje</th>

    </tr>
    </thead>
    <tbody>


    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id} </td>
            <td>${user.name} </td>
            <td>${user.lastName}</td>

            <td><a href="/app/users/delete/${user.id}">usuń </a> <a href="/app/users/update/${user.id}">edytuj </a> <a href="/app/users/toPdf/${user.id}">zapisz do pdf </a><a href="/app/users/showOne/${user.id}">szczegóły...</a> </td>


        </tr>
    </c:forEach>


    </tbody>
</table>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
