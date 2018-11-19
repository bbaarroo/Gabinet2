<%--
  Created by IntelliJ IDEA.
  User: bbi
  Date: 13.11.18
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Dodaj użytkownika</title>
    <%@include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/menu.jsp"%>
<h5>Dodaj użytkownika</h5>

<form:form method="post"
           action="/app/users/add"
           modelAttribute="user">

    <form:hidden path="id" />

    Imię: <form:input path="name" /><br>
    <form:errors path="name" /><br>

    Nawisko: <form:input path="lastName" /><br>
    <form:errors path="lastName" /><br>

    Pesel: <form:input path="pesel" /><br>
    <form:errors path="pesel" /><br>

    Numer telefonu: <form:input path="phnoneNumber" /><br>
    <form:errors path="phnoneNumber" /><br>


    Podaj dolegliwości <form:select path="diseaseList" items="${diseases}" itemLabel="name" itemValue="id"/><br>
    Wybierz suplementy <form:select path="suplements" items="${suplements}" itemLabel="name" itemValue="id"/><br>
    Wybierz terapeutę <form:select path="therapistList" items="${therapists}" itemLabel="name" itemValue="id"/><br>

    Zalecenia: <form:textarea path="recommendation" /><br>

    Data następnej wizyty <form:input type= "date" path="nextVisit" /><br>

    Uwagi: <form:textarea path="comments" /><br>

    <br>
    <br>
    <input type="submit" value="Save">

</form:form>

<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
