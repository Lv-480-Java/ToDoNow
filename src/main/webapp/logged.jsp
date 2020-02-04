<%@ page import="andriypyzh.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

</h2>
</body>
</html>