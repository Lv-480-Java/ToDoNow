<%@ page import="andriypyzh.entity.Project" %>
<%@ page import="andriypyzh.dao.Implementation.UserDao" %>
<%@ page import="andriypyzh.dao.Implementation.ProjectDao" %>
<%@ page import="andriypyzh.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projects</title>
</head>
<body>

<label for="project">Project:</label>
<jsp:include page="common/header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div>
    <form action="/Projects" method="get">
        <select id="project">
            <%
                ProjectDao projectDao = new ProjectDao();

                for (Project project : projectDao.getAllByUser((User) session.getAttribute("user"))) {
                    out.print("<option>");
                    out.print(project.getName());
                    out.print("</option>");
                }
            %>
        </select>

        <p><input type="submit" value="Submit"></p>
    </form>



</div>

</body>
</html>
