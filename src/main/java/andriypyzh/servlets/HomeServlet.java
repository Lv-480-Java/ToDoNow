package andriypyzh.servlets;

import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.services.ProjectService;
import andriypyzh.services.TaskService;
import andriypyzh.servlets.authentication.RegisterServlet;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("action");

        if (action == null) {
            doGet(request, response);
        } else {
            logout(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        logger.info(session.getAttribute("user").toString());

        TaskService taskService = new TaskService();
        ProjectService projectService = new ProjectService();

        try {
            User user = (User) session.getAttribute("user");

            List<Task> tasks = taskService.displayTasks(user);
            List<Project> projects = projectService.getAllUsersProjects(user);

            request.setAttribute("tasks", tasks);
            request.setAttribute("projects",projects);
            session.setAttribute("section", "Private Tasks of " + user.getUsername());

            logger.info(request.getAttribute("projects"));

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homepage");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/authentication");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}


