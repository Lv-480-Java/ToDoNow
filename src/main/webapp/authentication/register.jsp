
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <link href="./dashboard.css" rel="stylesheet"/>

    <link href="${pageContext.request.contextPath}/authentication/dashboard.css" rel="stylesheet"/>
    <link href="dashboard.css" rel="stylesheet"/>

    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">

</head>
<body class="">
<div class="page">
    <div class="page-single">
        <div class="container">
            <div class="row">
                <div class="col col-login mx-auto">
                    <form class="card" action="/todonow/RegisterServlet" method="post">
                        <div class="card-body p-6">
                            <div class="card-title">Create new account</div>
                            <div class="form-group">
                                <label class="form-label">Username</label>
                                <input type="text" class="form-control" placeholder="Enter name" name="username">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Password</label>
                                <input type="password" class="form-control" placeholder="Enter Password"
                                       name="password">
                            </div>
                            <div class="form-group">
                                <label class="form-label">Confirm Password</label>
                                <input type="password" class="form-control" placeholder="Confirm Password"
                                       name="confirm password">
                            </div>
                            <div class="form-footer">
                                <button type="submit" class="btn btn-primary btn-block">Create new account</button>
                            </div>
                        </div>
                    </form>
                    <div class="text-center text-muted">
                        Already have account? <a href="/todonow/authentication/login.jsp">Sign in</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/elements/alertBox.jsp"></jsp:include>
</body>
</html>
