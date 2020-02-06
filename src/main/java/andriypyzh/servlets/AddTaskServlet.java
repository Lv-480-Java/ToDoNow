package andriypyzh.servlets;

import andriypyzh.dao.Implementation.ProjectImpl;
import andriypyzh.dao.Implementation.TaskImpl;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.services.ProjectService;
import andriypyzh.services.TaskService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/AddTask")
public class AddTaskServlet extends HttpServlet {
    Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        TaskImpl taskDao = new TaskImpl();

        String taskName = request.getParameter("Name");
        int priority = Integer.parseInt(request.getParameter("Priority"));
        java.sql.Date deadline = java.sql.Date.valueOf(request.getParameter("Deadline"));
        String description = request.getParameter("Description");

        ProjectImpl project = new ProjectImpl();

        long millis = System.currentTimeMillis();
        java.sql.Date creationDate = new java.sql.Date(millis);

        Task task = new Task(0, taskName, user.getUsername(),
                project.getByName("default" + user.getUsername()).getId(), priority,
                creationDate, deadline, description, "created");

        taskDao.add(task);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
        requestDispatcher.forward(request, response);


    }
}
