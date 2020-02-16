<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">

    <title>Homepage</title>

    <link href="dashboard.css" rel="stylesheet"/>
</head>
<body class="">
<div class="page">
    <div class="flex-fill">
        <div class="header py-4">
            <div class="container">
                <div class="d-flex">
                    <a class="header-brand" href="./index.html">
                        <h2 class="section-title mb-2">ToDoNow</h2>
                    </a>
                    <div class="d-flex order-lg-2 ml-auto">

                        <div class="nav-item d-none d-md-flex">
                            <form method="get" action="/todonow/LogOutServlet">
                                <input class="btn btn-sm btn-outline-primary" target="_blank" type="submit"
                                       value="Log Out">
                            </form>
                        </div>

                        <div class="dropdown">
                            <a class="nav-link pr-0 leading-none" data-toggle="dropdown">
                                <span class="ml-2 d-none d-lg-block">
                                   <span class="text-default"><%=request.getSession().getAttribute("user")%></span>
                                </span>
                            </a>
                        </div>
                        <a href="#" class="header-toggler d-lg-none ml-3 ml-lg-0" data-toggle="collapse"
                           data-target="#headerMenuCollapse">
                            <span class="header-toggler-icon"></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>