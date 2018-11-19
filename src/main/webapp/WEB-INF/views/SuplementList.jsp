<%--
  Created by IntelliJ IDEA.
  User: bbi
  Date: 14.11.18
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista suplementów</title>
    <%@include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/menu.jsp"%>

<h1>Lista suplementów</h1>

<table border="2" class="table table-striped table-bordered table-hover">

    <thead>
    <tr>
        <th>id</th>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Akcje</th>

    </tr>
    </thead>
    <tbody>


    <c:forEach items="${suplements}" var="suplement">
        <tr>
            <td>${suplement.id} </td>
            <td>${suplement.name} </td>
            <td>${suplement.suplementDescription}</td>

            <td><a href="/app/suplements/delete/${suplement.id}">usuń</a> <a href="/app/suplements/update/${suplement.id}">edytuj</a> </td>
        </tr>
    </c:forEach>


    </tbody>
</table>



<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
