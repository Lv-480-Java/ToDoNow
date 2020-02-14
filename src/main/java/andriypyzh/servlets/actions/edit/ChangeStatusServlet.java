package andriypyzh.servlets.actions.edit;

import andriypyzh.entity.Task;
import andriypyzh.services.TaskService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ChangeStatus")
public class ChangeStatusServlet extends HttpServlet {
    public static final String CREATED = "created";
    public static final String IN_PROGRESS = "in progress";
    public static final String COMPLETED = "completed";
    Logger logger = Logger.getLogger(ChangeStatusServlet.class);
    TaskService taskService = new TaskService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("task"));
        Task task = taskService.getByID(id);

        if (task.getStatus().equals("created")) {
            task.setStatus("in progress");
            taskService.updateTask(task);
        } else if (task.getStatus().equals("in progress")) {
            task.setStatus("completed");
            taskService.updateTask(task);
        } else {
            logger.info("CANNOT CHANGE STATUS");
        }

        HttpSession session = request.getSession(false);
        String section = (String) session.getAttribute("section");

        if (section.startsWith("$")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
            requestDispatcher.forward(request, response);
        } else {
            logger.info("/Projects?project=" + section);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Projects?project=" + section);
            requestDispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int) request.getAttribute("task");
        Task task = taskService.getByID(id);

        if (task.getStatus().equals(CREATED)) {
            task.setStatus(IN_PROGRESS);
            taskService.updateTask(task);
        } else if (task.getStatus().equals(IN_PROGRESS)) {
            task.setStatus(COMPLETED);
            taskService.updateTask(task);
        } else {
            logger.info("CANNOT CHANGE STATUS");
        }

        HttpSession session = request.getSession(false);
        String section = (String) session.getAttribute("section");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Projects?project=" + section);
        requestDispatcher.forward(request, response);
    }
}
