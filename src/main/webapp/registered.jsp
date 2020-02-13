<%@ page import="andriypyzh.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registered Page</title>
</head>
<body>
<h4 align="center">Successfully registered <%out.print(request.getAttribute("user"));%></h4>
<h3 align="center" href="/authentication.jsp">OK</h3>


<%--<c:out value="${requestScope.user}">m</c:out>--%>


</body>
</html>
