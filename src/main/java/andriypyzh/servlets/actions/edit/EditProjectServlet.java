package andriypyzh.servlets.actions.edit;

import andriypyzh.entity.Project;
import andriypyzh.entity.User;
import andriypyzh.services.ProjectService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/EditProject")
public class EditProjectServlet extends HttpServlet {

    Logger logger = Logger.getLogger(EditTaskServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProjectService projectService = new ProjectService();

        HttpSession session = request.getSession(false);
        String section = (String) session.getAttribute("section");
        User user = (User) session.getAttribute("user");

        String projectName = request.getParameter("Name");
        java.sql.Date deadline = java.sql.Date.valueOf(request.getParameter("Deadline"));
        String description = request.getParameter("Description");
        String type = request.getParameter("Type");

        Project oldProject = projectService.getUsersProject(user, section);

        oldProject.setName(projectName);
        oldProject.setExpirationDate(deadline);
        oldProject.setDescription(description);
        oldProject.setType(type);

        projectService.updateProject(oldProject.getId(), projectName, deadline, description, type);

        request.setAttribute("project", oldProject);

        List<Project> projects = projectService.getAllUsersProjects(user);
        session.setAttribute("projects", projects);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Projects?project=" + projectName);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String projectName = (String) session.getAttribute("section");

        ProjectService projectService = new ProjectService();

        Project project = projectService.getByName(projectName);

        request.setAttribute("Name", project.getName());
        request.setAttribute("Deadline", project.getExpirationDate());
        request.setAttribute("Type", project.getType());
        request.setAttribute("Description", project.getDescription());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/forms/editproject.jsp");
        requestDispatcher.forward(request, response);
    }
}
