<%@ page import="andriypyzh.entity.Task" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<jsp:include page="/common/header.jsp"></jsp:include>

<jsp:include page="/menu.jsp"></jsp:include>

<div align="center">
    <form method="post" action="/create_task">
        <input type="submit" value="Add Task">
    </form>
</div>

<jsp:include page="tasks.jsp"></jsp:include>


<%--<table border="1" align="center" id="tableMain">--%>
<%--    <tbody>--%>
<%--    <tr>--%>
<%--        <th>Task</th>--%>
<%--        <th>Priority</th>--%>
<%--        <th>Created</th>--%>
<%--        <th>Deadline</th>--%>
<%--        <th>Description</th>--%>
<%--        <th>Status</th>--%>
<%--        <th>Edit</th>--%>
<%--    </tr>--%>

<%--    <%--%>
<%--        List<Task> tasks = (List<Task>) request.getAttribute("tasks");--%>
<%--        for (Task task : tasks) {--%>
<%--            out.print("<tr>");--%>

<%--            out.println("<td>" + task.getName() + "</td>");--%>
<%--            out.println("<td>" + task.getPriority() + "</td>");--%>
<%--            out.println("<td>" + task.getCreationDate() + "</td>");--%>
<%--            out.println("<td>" + task.getExpirationDate() + "</td>");--%>
<%--            out.println("<td>" + task.getDescription() + "</td>");--%>
<%--            out.println("<td>" + task.getStatus() + "</td>");--%>
<%--            out.println();--%>
<%--            out.print("</tr>");--%>
<%--        }--%>
<%--    %>--%>

<%--    </tbody>--%>

<%--</table>--%>


</body>
</html>
