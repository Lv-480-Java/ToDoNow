package andriypyzh.servlets.actions;

import andriypyzh.entity.Project;
import andriypyzh.entity.User;
import andriypyzh.services.TaskService;
import andriypyzh.services.validators.TaskValidator;
import andriypyzh.servlets.authentication.RegisterServlet;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/CreateTask")
public class CreateTaskServlet extends HttpServlet {
    Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String section = (String) session.getAttribute("section");

        try {
            String taskName = request.getParameter("Name");
            //
            int priority = Integer.parseInt(request.getParameter("Priority"));
            //
            java.sql.Date deadline = java.sql.Date.valueOf(request.getParameter("Deadline"));
            String description = request.getParameter("Description");

            TaskValidator taskValidator = new TaskValidator();
            taskValidator.validateData(taskName, priority, deadline, description);

            User user = (User) session.getAttribute("user");
            TaskService taskService = new TaskService();

            taskService.createTask(taskName, user.getUsername(), section,
                                    priority, deadline, description);

        } catch (NumberFormatException e){
            request.setAttribute("error", "illegal priority");
            logger.error("illegal priority");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("createtask.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            logger.error(e);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("createtask.jsp");
            requestDispatcher.forward(request, response);
            return;
        }

        if (section.startsWith("Private Tasks of")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
            requestDispatcher.forward(request, response);
        } else {
            logger.info("/Projects?project=" + section);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Projects?project=" + section);
            requestDispatcher.forward(request, response);
        }

    }
}
