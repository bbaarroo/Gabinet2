<%--
  Created by IntelliJ IDEA.
  User: kuba
  Date: 06.11.18
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <%@include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
<div align="center">
    <img src="https://images.freeimages.com/images/large-previews/69a/time-to-detox-1637160.png" height="300">
</div>

<h3 align="center">Gabinet terapii naturalnych</h3>
<h2></h2>

<form action="/login">
    <input type="submit" value="Zaloguj się"/>
</form>

<form action="/register">
    <input type="submit" value="Zarejestruj się"/>
</form>


<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
