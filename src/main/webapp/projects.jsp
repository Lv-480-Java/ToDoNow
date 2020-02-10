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

<jsp:include page="common/header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>

<jsp:include page="createtaskbutton.jsp"></jsp:include>
<jsp:include page="createprojectbutton.jsp"></jsp:include>
<jsp:include page="editprojectbutton.jsp"></jsp:include>

<div>
    <table style="width:100%">
        <tr>
            <th>Name:</th>
            <td><%=((Project)request.getAttribute("project")).getName()%></td>
        </tr>
        <tr>
            <th>Date Created:</th>
            <td><%=((Project)request.getAttribute("project")).getCreationDate()%></td>
        </tr>
        <tr>
            <th>Deadline:</th>
            <td><%=((Project)request.getAttribute("project")).getExpirationDate()%></td>
        </tr>
        <tr>
            <th>Status:</th>
            <td><%=((Project)request.getAttribute("project")).getStatus()%></td>
        </tr>
        <tr>
            <th>Type:</th>
            <td><%=((Project)request.getAttribute("project")).getType()%></td>
        </tr>
        <tr>
            <th>Creator:</th>
            <td><%=((Project)request.getAttribute("project")).getCreator()%></td>
        </tr>
        <tr>
            <th>Description:</th>
            <td><%=((Project)request.getAttribute("project")).getDescription()%></td>
        </tr>
    </table>

</div>

<div>
    <jsp:include page="tasks.jsp"></jsp:include>
</div>

</body>
</html>
