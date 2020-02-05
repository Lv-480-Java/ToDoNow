<%@ page import="andriypyzh.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Logged page</title>
</head>
<body>
<h1>Successfully logged</h1>
<h2>
    <%
        out.print(((User) request.getSession().getAttribute("user")).getUsername());
    %>

    <c:out value="${requestScope.user.username}"/>


</h2>
</body>
</html>