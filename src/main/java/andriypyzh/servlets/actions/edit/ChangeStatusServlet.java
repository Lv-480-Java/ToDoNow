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

    Logger logger = Logger.getLogger(ChangeStatusServlet.class);
    TaskService taskService = new TaskService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("task"));
        Task task = taskService.getByID(id);

        taskService.changeStatus(task);

        HttpSession session = request.getSession(false);
        String section = (String) session.getAttribute("section");

        logger.info("Section " + section);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Projects?project=" + section);
        requestDispatcher.forward(request, response);
    }
}
