<%@ page import="andriypyzh.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Successfully registered

<%
    out.print(((User) request.getAttribute("user")).getUsername());
%>

</h1>

<%--<c:out value="${requestScope.user}">m</c:out>--%>


</body>
</html>
