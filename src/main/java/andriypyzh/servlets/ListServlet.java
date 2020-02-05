package andriypyzh.servlets;

import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.services.ProjectService;
import andriypyzh.services.TaskService;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Task> tasks = new ArrayList<>();
        HttpSession session = request.getSession();
        logger.info( session.getAttribute("user").toString());

        TaskService taskService = new TaskService();


        try {
            User user = (User)session.getAttribute("user");
            tasks = taskService.displayTasks(user);

            request.setAttribute("tasks",tasks);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("tasklist.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
