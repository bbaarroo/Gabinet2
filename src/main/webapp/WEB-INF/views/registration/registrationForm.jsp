<%--
  Created by IntelliJ IDEA.
  User: bbi
  Date: 09.11.18
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rejestracja</title>
    <%@include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
<div align="center">
    <img src="https://images.freeimages.com/images/large-previews/69a/time-to-detox-1637160.png" height="300">
</div>

<h3 align="center">Gabinet terapii naturalnych</h3>

<h2>Rejestracja</h2>

<form:form method="post"
           modelAttribute="registrationDto">


    Imię: <form:input path="name"/><br>
    <form:errors path="name"/><br>

    Nazwisko: <form:input path="lastName"/><br>
    <form:errors path="lastName"/><br>


    Login: <form:input path="login"/><br>
    <form:errors path="login"/><br>

    Hasło: <form:password path="password"/><br>
    Powtórz hasło: <form:password path="passwordRepeat"/><br>
    <form:errors path="password"/><br>




    <input type="submit" value="Zarejestruj się">
</form:form>
<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
