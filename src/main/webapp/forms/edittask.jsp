<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>

<div align="center">
    <h1>Edit Task</h1>
    <form action="/EditTask" method="post">
        <table style="with: 80%">
            <tr>
                <td>Task Name</td>
                <td><input type="text" name="Name" value="<%= request.getAttribute("name")%>"></td>
            </tr>
            <tr>
                <td>Priority</td>
                <td><input type="text" name="Priority" value=<%= request.getAttribute("priority")%>></td>
            </tr>
            <tr>
                <td>Deadline</td>
                <td><input type="date" name="Deadline" value=<%= request.getAttribute("deadline")%>></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="Description" value="<%= (String)request.getAttribute("description")%>"></td>
            </tr>
        </table>
        <input type="submit" value="Edit"/>

        <a href="/home"> Cancel </a>
        <a href="/DeleteTask"> Delete </a>


    </form>
</div>


</body>
</html>
