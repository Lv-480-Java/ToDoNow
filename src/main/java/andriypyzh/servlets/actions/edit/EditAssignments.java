package andriypyzh.servlets.actions.edit;

import andriypyzh.entity.Project;
import andriypyzh.entity.User;
import andriypyzh.services.ProjectService;
import andriypyzh.services.UserService;
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

@WebServlet("/EditAssignments")
public class EditAssignments extends HttpServlet {

    Logger logger = Logger.getLogger(EditAssignments.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectService projectService = new ProjectService();
        UserService userService = new UserService();

        HttpSession session = request.getSession(false);
        String section = (String) session.getAttribute("section");

        User user = (User) session.getAttribute("user");
        Project project = projectService.getUsersProject(user, section);
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        User newUser = userService.getByUsername(username);

        if (action.equals("add")) {

            projectService.assignUserToProject(newUser, project);

        } else if (action.equals("remove")) {

            projectService.unassignUserToProject(newUser, project);

        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Projects?project=" + section);
            requestDispatcher.forward(request, response);
            return;
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EditAssignments");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String projectName = (String) session.getAttribute("section");
        User user = (User) session.getAttribute("user");

        ProjectService projectService = new ProjectService();

        List<String> notAssignedUsers = projectService
                .getNotAssignedUsers(projectService.getByName(projectName));

        List<String> assignedUsers = projectService
                .getAssignedUsers(projectService.getByName(projectName));
        assignedUsers.remove(user.getUsername());

        request.setAttribute("notAssignedUsers", notAssignedUsers);
        request.setAttribute("assignedUsers", assignedUsers);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/forms/editassignments.jsp");
        requestDispatcher.forward(request, response);
    }

}
