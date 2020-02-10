<%@ page import="andriypyzh.entity.Project" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<div>
    <ul>
        <li><a href="/home">Tasks</a></li>
        <li><a href="/created">Created</a></li>
        <li><a href="/in_progress">In Progress</a></li>
        <li><a href="/competed">Completed</a></li>
        <li><a href="/failed">Failed</a></li>

        <%
            List<Project> projects = (List<Project>) request.getAttribute("projects");
            for (Project project : projects) {
                if (!project.getType().equals("default")) {
                    out.print("<li><a href =/Projects?project=" + project.getName().replace(" ","+") + ">");
                    out.println(project.getName());
                    out.print("</a></li>");
                }
            }
        %>

    </ul>
</div>

</body>
</html>
