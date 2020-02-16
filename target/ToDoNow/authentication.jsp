<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body>
<div align="center">
    <h1>Register</h1>
    <form action="RegisterServlet" method="post">
        <table style="with: 80%">
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Confirm password</td>
                <td><input type="password" name="confirm password"/></td>
            </tr>
        </table>
        <input type="submit" value="Register"/>
    </form>

    <h2>OR</h2>

    <h1>Log In</h1>
    <form action="LoginServlet" method="post">
        <table style="with: 80%">
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
        </table>
        <input type="submit" value="Log In"/>
    </form>
</div>

<jsp:include page="elements/alertBox.jsp"></jsp:include>

</body>

</html>
