<html lang="en">
<head>
    <title>New Task</title>

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
                    <form class="card" action="/todonow/CreateTask" method="post">
                        <div class="card-body p-6">
                            <div align="center">
                                <h2>New Task</h2>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Task Name</label>
                                <input type="text" class="form-control"
                                       placeholder="Enter task name" name="Name">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Priority</label>
                                <input type="number" class="form-control"
                                       placeholder="Enter priority" name="Priority">
                            </div>

                            <div class="form-group">
                                <label class="form-label">Deadline</label>
                                <input type="date" class="form-control"
                                       value="<%= new java.sql.Date(System.currentTimeMillis()) %>"
                                       placeholder="Enter deadline" name="Deadline">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Description</label>
                                <textarea class="form-control" rows="6"
                                          placeholder="Some description..." name="Description"></textarea>
                            </div>
                            <div class="form-footer">
                                <button type="submit" class="btn btn-primary btn-block">Create</button>
                                <a href="/todonow/Projects?project=<%=session.getAttribute("section")%>"
                                   class="btn btn-secondary ml-2 btn-block">Cancel</a>
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
