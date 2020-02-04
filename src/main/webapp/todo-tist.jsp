<%--
  Created by IntelliJ IDEA.
  User: andriypyzh
  Date: 01.02.2020
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!--   for (Todo todo: todos) {  -->
<c:forEach var="todo" items="${listTodo}">

    <tr>
        <td><c:out value="${todo.title}"/></td>
        <td><c:out value="${todo.targetDate}"/></td>
        <td><c:out value="${todo.status}"/></td>

        <td><a href="edit?id=<c:out value='${todo.id}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp; <a
                    href="delete?id=<c:out value='${todo.id}' />">Delete</a></td>

    </tr>
</c:forEach>
<!-- } -->
</body>
</html>
