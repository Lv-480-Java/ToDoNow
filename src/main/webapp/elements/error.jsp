<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Error page</h1>
    <% out.print(request.getAttribute("msg"));%>

</div>


</body>
</html>
