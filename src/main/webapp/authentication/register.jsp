<%--
  Created by IntelliJ IDEA.
  User: andriypyzh
  Date: 16.02.2020
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Content-Language" content="en"/>
    <meta name="msapplication-TileColor" content="#2d89ef">
    <meta name="theme-color" content="#4188c9">

    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
    <!-- Dashboard Core -->
    <link href="<%=request.getContextPath()%>/authentication/dashboard.css" rel="stylesheet" />

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
                        Already have account? <a href="login.jsp">Sign in</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/elements/alertBox.jsp"></jsp:include>
</body>
</html>
