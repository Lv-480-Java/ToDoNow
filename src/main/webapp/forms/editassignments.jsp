<%@ page import="java.util.List" %>
<html lang="en">
<head>
    <title>Edit Assignments</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
    <link href="<%=request.getContextPath()%>/authentication/dashboard.css" rel="stylesheet"/>
</head>
<body class="antialiased">
<div class="mypage">
    <div class="container">
        <div class="assign-con" align="center">
            <h1 class="page-title1">
                Edit Assignments
            </h1>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Not Assigned</h3>
                    </div>
                    <div class="card-body">


                        <form>
                            <select id="SelectUnassigned" size="7" class="mylistbox">
                                <%
                                    List<String> unassignedUsernames = (List<String>) request.getAttribute("notAssignedUsers");
                                    for (String username : unassignedUsernames) {
                                        out.print("<option>" + username + "</option>");
                                    }
                                %>
                            </select>
                        </form>

                        <button onclick="addUser()"
                                class="btn btn-primary ml-2 btn-block">Assign
                        </button>

                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Assigned</h3>
                    </div>
                    <div class="card-body">
                        <form>
                            <select id="SelectAssigned" size="7" class="mylistbox">
                                <%
                                    List<String> assignedUsernames = (List<String>) request.getAttribute("assignedUsers");
                                    for (String username : assignedUsernames) {
                                        out.print("<option>" + username + "</option>");
                                    }
                                %>
                            </select>
                        </form>

                        <button class="btn btn-outline-danger active btn-block" onclick="removeUser()">Unassign</button>

                    </div>
                </div>
            </div>

            <a href="/todonow/Projects?project=<%=session.getAttribute("section")%>"
               class="btn btn-secondary ml-2 btn-block align-self-center">Cancel</a>

        </div>
    </div>
</div>


<script>

    function addUser() {
        var x = document.getElementById("SelectUnassigned");
        const Http = new XMLHttpRequest();
        const url = "/todonow/EditAssignments?action=add&username=" + x.options[x.selectedIndex].value;
        Http.open("POST", url);
        Http.send();
    }


    function removeUser() {
        var x = document.getElementById("SelectAssigned");
        const Http = new XMLHttpRequest();
        const url = "/todonow/EditAssignments?action=remove&username=" + x.options[x.selectedIndex].value;
        Http.open("POST", url);
        Http.send();
    }
</script>


</body>
</html>
