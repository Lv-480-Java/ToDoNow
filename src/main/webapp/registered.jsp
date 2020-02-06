<%@ page import="andriypyzh.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Successfully registered

    <jsp:useBean id="user" scope="request" type="andriypyzh.entity.User"/>
    <c:out value="user.username">nvh</c:out>

    <%
        out.print(((User) request.getAttribute("user")).getUsername());
    %>

    <a href="/authentication">OK</a>

</h1>

<%--<c:out value="${requestScope.user}">m</c:out>--%>


</body>
</html>
