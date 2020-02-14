<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<jsp:include page="common/header.jsp"></jsp:include>

<jsp:include page="elements/menu.jsp"></jsp:include>

<p align="center"><%out.print(session.getAttribute("section"));%></p>

<jsp:include page="buttons/createtaskbutton.jsp"></jsp:include>
<jsp:include page="buttons/createprojectbutton.jsp"></jsp:include>
<jsp:include page="elements/tasks.jsp"></jsp:include>

</body>
</html>
