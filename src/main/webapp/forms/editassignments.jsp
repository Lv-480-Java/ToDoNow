<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Edit Assignments</h1>

</div>

<div align="center">
    <form>
        All users
        <br>
        <select id="SelectUnassigned" size="5">
            <%
                List<String> unassignedUsernames = (List<String>) request.getAttribute("notAssignedUsers");
                for (String username : unassignedUsernames) {
                    out.print("<option>" + username + "</option>");
                }
            %>
        </select>
    </form>
    <br>
    <button onclick="addUser()">Assign</button>
</div>

<div align="center">
    <form>
        Assigned users
        <br>
        <select id="SelectAssigned" size="5">
            <%
                List<String> assignedUsernames = (List<String>) request.getAttribute("assignedUsers");
                for (String username : assignedUsernames) {
                    out.print("<option>" + username + "</option>");
                }
            %>
        </select>
    </form>
    <br>
    <button onclick="removeUser()">Unassign</button>
</div>

<div align="center"><a href="/todonow/home" > Cancel </a></div>

<script>

    function addUser() {
        var x = document.getElementById("SelectUnassigned");
        // x.remove(x.selectedIndex);

        const Http = new XMLHttpRequest();
        const url="/todonow/EditAssignments?action=add&username=" + x.options[x.selectedIndex].value;
        Http.open("POST", url);
        Http.send();
    }


    function removeUser() {
        var x = document.getElementById("SelectAssigned");
        // x.remove(x.selectedIndex);

        const Http = new XMLHttpRequest();
        const url="/todonow/EditAssignments?action=remove&username=" + x.options[x.selectedIndex].value;
        Http.open("POST", url);
        Http.send();
    }
</script>


</body>
</html>
