<%--
  Created by IntelliJ IDEA.
  User: bbi
  Date: 15.11.18
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <%@include file="/WEB-INF/views/fragments/header.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/menu.jsp"%>


<h2 align="center" style="color:blue;">Witaj, ${user.name} ${user.lastName} !!!</h2>


<jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</body>
</html>
