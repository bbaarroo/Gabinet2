<%--
  Created by IntelliJ IDEA.
  User: bbi
  Date: 14.11.18
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista chorób</title>
    <%@include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/menu.jsp"%>
<h1>Lista chorób</h1>

<table border="2" class="table table-striped table-bordered table-hover">

    <thead>
    <tr>
        <th>id</th>
        <th>Nazwa</th>
        <th>Akcje</th>

    </tr>
    </thead>
    <tbody>


    <c:forEach items="${diseases}" var="disease">
        <tr>
            <td>${disease.id} </td>
            <td>${disease.name} </td>

            <td><a href="/app/diseases/delete/${disease.id}">usuń</a> <a href="/app/diseases/update/${disease.id}">edytuj</a> </td>
        </tr>
    </c:forEach>


    </tbody>
</table>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
