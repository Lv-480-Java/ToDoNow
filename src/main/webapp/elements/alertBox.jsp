<%--
  Created by IntelliJ IDEA.
  User: andriypyzh
  Date: 11.02.2020
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
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
