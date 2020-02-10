<%@ page import="andriypyzh.entity.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks</title>
</head>
<body>


<table border="1" align="center">
    <tbody>
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
            out.println("<td><a href=/EditTask?task=" + task.getId() + "> edit </a> </td>");
            out.print("</tr>");
        }
    %>
    </tbody>
</table>

</body>
</html>
