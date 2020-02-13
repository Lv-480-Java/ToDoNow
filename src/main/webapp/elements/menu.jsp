<%@ page import="andriypyzh.entity.Project" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<div class="menu">
    <ul>
        <li><a href="/home">Tasks</a></li>
        <li><a href="/CategoryStatus?status=created">Created</a></li>
        <li><a href="/CategoryStatus?status=in+progress">In Progress</a></li>
        <li><a href="/CategoryStatus?status=completed">Completed</a></li>

        <%
            List<Project> projects = (List<Project>) session.getAttribute("projects");
            if (projects.size()!=1){
                out.print("<p>Projects:</p>");
            }
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
