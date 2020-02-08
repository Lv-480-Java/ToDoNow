package andriypyzh.servlets.actions;

import andriypyzh.entity.User;
import andriypyzh.services.TaskService;
import andriypyzh.servlets.authentication.RegisterServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/CreateTask")
public class CreateTaskServlet extends HttpServlet {
    Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String project = (String) session.getAttribute("section");

        String taskName = request.getParameter("Name");
        int priority = Integer.parseInt(request.getParameter("Priority"));
        java.sql.Date deadline = java.sql.Date.valueOf(request.getParameter("Deadline"));
        String description = request.getParameter("Description");

        User user = (User) session.getAttribute("user");
        TaskService taskService = new TaskService();

        taskService.createTask(taskName,user.getUsername(),project,
                            priority,deadline,description);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
        requestDispatcher.forward(request, response);
    }
}
