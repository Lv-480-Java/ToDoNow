<%@ page import="andriypyzh.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registered Page</title>
</head>
<body>
<h4 align="center">Successfully registered <%out.print(request.getAttribute("user"));%></h4>
<div align="center"><a href="/authentication.jsp">Go Back</a></div>

</body>
</html>
