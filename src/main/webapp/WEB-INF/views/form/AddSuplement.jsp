<%--
  Created by IntelliJ IDEA.
  User: bbi
  Date: 14.11.18
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Dodaj suplement</title>
    <%@include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/menu.jsp"%>
<h5>Dodaj suplement</h5>

<form:form method="post"
           action="/app/suplements/add"
           modelAttribute="suplement">

    <form:hidden path="id" />

    Nazwa: <form:input path="name" /><br>
    <form:errors path="name" /><br>

    Opis: <form:textarea path="suplementDescription" /><br>
    <form:errors path="suplementDescription" /><br>



    <br>
    <br>
    <input type="submit" value="Save">

</form:form>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
