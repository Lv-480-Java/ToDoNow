<%@ page import="andriypyzh.entity.Task" %>
<%@ page import="java.util.List" %>


<div class="card">
    <div class="card-header">
        <h3 class="card-title">Tasks</h3>
    </div>

    <div class="table-responsive">
        <table class="table card-table table-vcenter text-nowrap datatable">
            <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Priority</th>
                <th>Created</th>
                <th>Deadline</th>
                <th>Status</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Task> tasks = (List<Task>) request.getAttribute("tasks");

                for (Task task : tasks) {
                    out.print("<tr>");

                    out.println("<td><span class=\"text-reset\">" + task.getName() + "</span></td>");
                    out.println("<td>" + task.getDescription() + "</td>");
                    out.println("<td>" + task.getPriority() + "</td>");
                    out.println("<td>" + task.getCreationDate() + "</td>");
                    out.println("<td>" + task.getExpirationDate() + "</td>");
                    out.println("<td><a href=/todonow/ChangeStatus?task=" + task.getId() + ">" + task.getStatus() + "</a></td>");
                    out.println("<td><a href=/todonow/EditTask?task=" + task.getId() + "> edit </a> </td>");
                    out.print("</tr>");
                }
            %>
            </tbody>
        </table>
    </div>

</div>
</div>
