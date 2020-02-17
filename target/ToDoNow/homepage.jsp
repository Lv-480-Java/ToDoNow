<%@ page import="andriypyzh.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>

<body>

<jsp:include page="common/header.jsp"></jsp:include>

<div class="mypage">
    <div class="container">
        <h2 align="center"><%=((User) session.getAttribute("user")).getUsername() + "'s Tasks"%>
        </h2>

        <div class="row">
            <div class="col-3">

                <jsp:include page="/elements/menu.jsp"></jsp:include>
                <jsp:include page="/buttons/createtaskbutton.jsp"></jsp:include>
                <jsp:include page="/buttons/createprojectbutton.jsp"></jsp:include>

            </div>

            <div class="col-9">
                <jsp:include page="/elements/tasks.jsp"></jsp:include>
            </div>

        </div>
    </div>
</div>
</body>

</html>
