<%--
  Created by IntelliJ IDEA.
  User: andriypyzh
  Date: 07.02.2020
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
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
        <% out.print(request.getSession().getAttribute("user")); %>
    </h2>
</div>

<div align="right">
    <form method="get" action="/LogOutServlet">
        <input type="submit" value="Log Out">
    </form>
</div>

</body>

</html>
