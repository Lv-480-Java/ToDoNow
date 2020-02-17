<html lang="en">
<head>
    <title>Edit Project</title>
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
                    <form class="card" action="/todonow/EditProject" method="post">
                        <div class="card-body p-6">
                            <div align="center">
                                <h2>Edit Project</h2>
                            </div>
                            <div class="form-group">
                                <label class="form-label">Project Name</label>
                                <input type="text" class="form-control"
                                       value="<%=request.getAttribute("Name")%>" name="Name">
                            </div>

                            <div class="form-group">
                                <label class="form-label">Deadline</label>
                                <input type="date" class="form-control"
                                       value="<%=request.getAttribute("Deadline")%>"
                                       name="Deadline">
                            </div>

                            <div class="form-group">
                                <label class="form-label">Type</label>
                                <input type="text" class="form-control"
                                       value="<%=request.getAttribute("Type")%>"
                                       name="Type">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Description</label>
                                <textarea class="form-control" rows="6"
                                          placeholder="Some description..."
                                          name="Description"><%=request.getAttribute("Description")%></textarea>
                            </div>
                            <div class="form-footer">
                                <button type="submit" class="btn btn-primary btn-block">Edit</button>
                                <a href="/todonow/Projects?project=<%=session.getAttribute("section")%>"
                                   class="btn btn-secondary ml-2 btn-block">Cancel</a>
                                <a href="/todonow/DeleteProject"
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
