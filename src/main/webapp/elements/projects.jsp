<%@ page import="andriypyzh.entity.Project" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projects</title>
</head>


<body>

<jsp:include page="/common/header.jsp"></jsp:include>


<div class="mypage">
    <div class="content">
        <div class="container">
            <h2 align="center"><%out.print(session.getAttribute("section"));%></h2>
            <div class="row">
                <div class="col-3">

                    <jsp:include page="/elements/menu.jsp"></jsp:include>
                    <jsp:include page="/buttons/createtaskbutton.jsp"></jsp:include>
                    <jsp:include page="/buttons/createprojectbutton.jsp"></jsp:include>
                    <jsp:include page="/buttons/editprojectbutton.jsp"></jsp:include>
                    <jsp:include page="/buttons/editassinmentsbutton.jsp"></jsp:include>

                </div>
                <div class="col-9">
                    <div class="card">
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap datatable">
                                <tr>
                                    <th>Name:</th>
                                    <td><%=((Project) request.getAttribute("project")).getName()%>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Date Created:</th>
                                    <td><%=((Project) request.getAttribute("project")).getCreationDate()%>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Creator:</th>
                                    <td><%=((Project) request.getAttribute("project")).getCreator()%>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Deadline:</th>
                                    <td><%=((Project) request.getAttribute("project")).getExpirationDate()%>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Status:</th>
                                    <td><%=((Project) request.getAttribute("project")).getStatus()%>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Type:</th>
                                    <td><%=((Project) request.getAttribute("project")).getType()%>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Description:</th>
                                    <td><%=((Project) request.getAttribute("project")).getDescription()%>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Assigned:</th>
                                    <td><%
                                        List<String> usernames = (List<String>) request.getAttribute("assignments");
                                        Iterator<String> iterator = usernames.iterator();
                                        StringBuffer stringBuffer = new StringBuffer();
                                        while (iterator.hasNext()){
                                            stringBuffer.append(iterator.next() + ", ");
                                        }
                                        stringBuffer.deleteCharAt(stringBuffer.length()-2);
                                        out.print(stringBuffer);
                                    %></td>
                                </tr>


                            </table>
                        </div>
                    </div>
                    <jsp:include page="/elements/tasks.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>