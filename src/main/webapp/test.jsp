<%@ page import="andriypyzh.entity.Project" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">

    <link href="dashboard.css" rel="stylesheet"/>

</head>
<body class="">
<div class="mypage">
    <div class="col-sm-6 col-lg-4">
        <div class="card">
            <%--            <div class="card-header">--%>
            <%--                <h4 class="card-title">Browser Stats</h4>--%>
            <%--            </div>--%>
            <table class="table card-table">

                <tr>
                    <td>
                        <a href="/todonow/home">Tasks</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="/todonow/CategoryStatus?status=created">Created</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="/todonow/CategoryStatus?status=in+progress">In Progress</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="/todonow/CategoryStatus?status=completed">Completed</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>

</div>


<div class="mypage">
    <div class="card-header">
        <h4 class="card-title">Projects</h4>
    </div>
    <div class="col-sm-6 col-lg-4">
        <div class="card">
            <table class="table card-table">

                <%
                    List<Project> projects = (List<Project>) session.getAttribute("projects");
                    for (Project project : projects) {
                        if (!project.getType().equals("default")) {
                            out.print("<tr><td><a href =/todonow/Projects?project=" + project.getName().replace(" ", "+") + ">");
                            out.println(project.getName());
                            out.print("</a></td></tr>");
                        }
                    }
                %>
            </table>
        </div>
    </div>

</div>

</body>
</html>