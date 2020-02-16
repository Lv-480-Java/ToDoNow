<%@ page import="java.util.List" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
    <link href="<%=request.getContextPath()%>/authentication/dashboard.css" rel="stylesheet"/>
</head>
<body class="antialiased">
<div class="mypage">
    <div class="container">
        <div class="assign-con" align="center">
            <h1 class="page-title">
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

                        <div class="dropdown-menu position-relative d-inline-block mr-3 mb-3 align-top">

                            <form>
                                Assigned users
                                <br>
                                <select id="SelectAssigned" size="5">
                                    <%
                                        List<String> assignedUsernames = (List<String>) request.getAttribute("assignedUsers");
                                        for (String username : assignedUsernames) {
                                            out.print("<option class=\"dropdown-item\">" + username + "</option>");
                                        }
                                    %>
                                </select>
                            </form>

<%--                            <a class="dropdown-item">item</a>--%>
<%--                            <a class="dropdown-item">item</a>--%>
<%--                            <a class="dropdown-item">item</a>--%>
<%--                            <a class="dropdown-item">item</a>--%>


                        </div>
                        <a href="/todonow/Projects?project=<%=session.getAttribute("section")%>"
                           class="btn btn-secondary ml-2 btn-block">Cancel</a>

                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Assigned</h3>
                    </div>
                    <div class="card-body">

                        <div class="dropdown-menu position-relative d-inline-block mr-3 mb-3 align-top">

                            <a class="dropdown-item">item</a>
                            <a class="dropdown-item">item</a>
                            <a class="dropdown-item">item</a>
                            <a class="dropdown-item">item</a>


                        </div>
                        <a href="/todonow/Projects?project=<%=session.getAttribute("section")%>"
                           class="btn btn-secondary ml-2 btn-block">Cancel</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>