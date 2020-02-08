<%@ page import="andriypyzh.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>

<body>

<div align="left">
    <h2>ToDoNow</h2>
</div>

<div>
    <h2>
        <% out.print(((User)request.getSession().getAttribute("user")).getUsername()); %>
    </h2>
</div>

<div align="right">
    <form method="get" action="/LogOutServlet">
        <input type="submit" value="Log Out">
    </form>
</div>

</body>

</html>
