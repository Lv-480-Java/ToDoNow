package andriypyzh.servlets.sections;

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

@WebServlet("/Projects")
public class ProjectServlet extends HttpServlet {

    Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        logger.info(session.getAttribute("user").toString());
        logger.info(session.getAttribute("section").toString());


        TaskService taskService = new TaskService();

        try {
            User user = (User) session.getAttribute("user");

            ProjectService projectService = new ProjectService();

            List<Project> projects = projectService.getAllUsersProjects(user);

            request.setAttribute("projects", projects);

            //
            String projectName = request.getParameter("project").replace("+", " ");
            //

            Project project = projectService.getUsersProject(user, projectName);
            List<Task> tasks = projectService.getProjectTasks(user, projectName);

            request.setAttribute("tasks", tasks);
            request.setAttribute("project", project);
            request.setAttribute("assignments", projectService.getAssignedUsers(project));
            session.setAttribute("section", project.getName());

            if (project.getName().startsWith("Tasks of")) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
                requestDispatcher.forward(request, response);
                return;
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/elements/projects.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            logger.error(e);
        }
    }
}


