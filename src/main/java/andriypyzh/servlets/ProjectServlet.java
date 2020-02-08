package andriypyzh.servlets;

import andriypyzh.dao.Implementation.ProjectDao;
import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.services.ProjectService;
import andriypyzh.services.TaskService;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Projects")
public class ProjectServlet extends HttpServlet {

    Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        List<Task> tasks = new ArrayList<>();
        HttpSession session = request.getSession();
        logger.info(session.getAttribute("user").toString());
//        logger.info(session.getAttribute("project").toString());


        TaskService taskService = new TaskService();

        try {
            User user = (User) session.getAttribute("user");
            String projectName = request.getParameter("project");
            ProjectService projectService = new ProjectService();

            Project project = projectService.getUsersProject(user,projectName);
            tasks = projectService.getProjectTasks(user,projectName);

            request.setAttribute("tasks", tasks);
            request.setAttribute("project",project);
            //
            session.setAttribute("section", "Private Tasks of " + user.getUsername());
            //

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/projects");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


