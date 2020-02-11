package andriypyzh.servlets.actions;

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

@WebServlet("/DeleteTask")
public class DeleteTaskServlet extends HttpServlet {
    Logger logger = Logger.getLogger(DeleteTaskServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String section = (String) session.getAttribute("section");

        int taskId =(int)session.getAttribute("edittask");

        TaskService taskService= new TaskService();
        taskService.deleteTask(taskId);

        if (section.startsWith("Private Tasks of")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Projects?project=" + section);
            requestDispatcher.forward(request, response);
        }
    }
}
