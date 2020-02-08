<%--
  Created by IntelliJ IDEA.
  User: andriypyzh
  Date: 05.02.2020
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Task</title>
</head>
<body>
<div align="center">
    <h1>Add Task</h1>
    <form action="/CreateTask" method="post">
        <table style="with: 80%">
            <tr>
                <td>Task Name</td>
                <td><input type="text" name="Name"/></td>
            </tr>
            <tr>
                <td>Priority</td>
                <td><input type="text" name="Priority"/></td>
            </tr>
            <tr>
                <td>Deadline</td>
                <td><input type="text" name="Deadline"/></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="Description"/></td>
            </tr>
        </table>
        <input type="submit" value="Create"/>

        <a href="/home"> Cancel </a>

    </form>
</div>


</body>
</html>
