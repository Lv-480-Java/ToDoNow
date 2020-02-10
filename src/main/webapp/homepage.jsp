<%@ page import="andriypyzh.entity.Task" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<jsp:include page="common/header.jsp"></jsp:include>

<jsp:include page="menu.jsp"></jsp:include>

<jsp:include page="createtaskbutton.jsp"></jsp:include>
<jsp:include page="createprojectbutton.jsp"></jsp:include>
<jsp:include page="tasks.jsp"></jsp:include>

</body>
</html>
