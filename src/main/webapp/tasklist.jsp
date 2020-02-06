<%@ page import="andriypyzh.entity.Task" %>
<%@ page import="java.util.List" %><%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<div align="center">
    <form method="post" action="/home?action=logout">
        <input type="submit" value="Log Out">
    </form>
</div>

<div align="center">
    <form method="post" action="/addtask">
        <input type="submit" value="Add Task">
    </form>
</div>

<h3 align="center">Tasks</h3>

<table border="1" align="center">
    <tr>
        <th>Task</th>
        <th>Priority</th>
        <th>Created</th>
        <th>Deadline</th>
        <th>Description</th>
        <th>Status</th>
        <th>Edit</th>
    </tr>
    <%
        List<Task> tasks = (List<Task>) request.getAttribute("tasks");
        for (Task task : tasks) {
            out.print("<tr>");

            out.println("<td>" + task.getName() + "</td>");
            out.println("<td>" + task.getPriority() + "</td>");
            out.println("<td>" + task.getCreationDate() + "</td>");
            out.println("<td>" + task.getExpirationDate() + "</td>");
            out.println("<td>" + task.getDescription() + "</td>");
            out.println("<td>" + task.getStatus() + "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
