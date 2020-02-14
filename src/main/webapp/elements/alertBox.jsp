<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alert Box</title>
</head>
<body>

<script type="text/javascript">
    var Msg ='<%=(String)request.getAttribute("error")%>';
    if (Msg!=="null") {
        alert(Msg);
    }
</script>

</body>
</html>
