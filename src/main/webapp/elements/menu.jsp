<%@ page import="andriypyzh.entity.Project" %>
<%@ page import="java.util.List" %>
<a class="list-group-item list-group-item-action d-flex align-items-center"
   href="/todonow/home">
    Tasks
</a>
<a class="list-group-item list-group-item-action d-flex align-items-center"
   href="/todonow/CategoryStatus?status=created">
    Created
</a>
<a class="list-group-item list-group-item-action d-flex align-items-center"
   href="/todonow/CategoryStatus?status=in+progress">
    In progress
</a>
<a class="list-group-item list-group-item-action d-flex align-items-center"
   href="/todonow/CategoryStatus?status=completed">
    Completed
</a>
<div align="center"><h5><br> Projects</h5></div>

<%
    List<Project> projects = (List<Project>) session.getAttribute("projects");
    for (Project project : projects) {
        if (!project.getType().equals("default")) {
            out.print("<a class=\"list-group-item list-group-item-action d-flex align-items-center\" href =/todonow/Projects?project=" + project.getName().replace(" ", "+") + ">");
            out.println(project.getName());
            out.print("</a>");
        }
    }
%>
