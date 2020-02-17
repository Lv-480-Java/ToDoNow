<html lang="en">
<head>
    <title>Edit Task</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
    <link href="<%=request.getContextPath()%>/authentication/dashboard.css" rel="stylesheet"/>
</head>
<body class="antialiased">


<div class="page">
    <div class="page-single">
        <div class="container">
            <div class="row">
                <div class="col col-login mx-auto">
                    <form class="card" action="/todonow/EditTask" method="post">
                        <div class="card-body p-6">
                            <div align="center">
                                <h2>Edit Task</h2>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Task Name</label>
                                <input type="text" class="form-control"
                                       value="<%= request.getAttribute("name")%>" name="Name">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Priority</label>
                                <input type="number" class="form-control"
                                       value=<%= request.getAttribute("priority")%> name="Priority">
                            </div>

                            <div class="form-group">
                                <label class="form-label">Deadline</label>
                                <input type="date" class="form-control"
                                       value="<%= request.getAttribute("deadline")%>"
                                       name="Deadline">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Description</label>
                                <textarea class="form-control" rows="6"
                                          name="Description"><%out.print(((String)request.getAttribute("description")));%></textarea>
                            </div>

                            <div class="form-footer">
                                <button type="submit" class="btn btn-primary btn-block">Edit</button>
                                <a href="/todonow/Projects?project=<%=session.getAttribute("section")%>"
                                   class="btn btn-secondary ml-2 btn-block">Cancel</a>
                                <a href="/todonow/DeleteTask"
                                   class="btn btn-outline-danger btn-block">Delete</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/elements/alertBox.jsp"></jsp:include>

</body>
</html>
