package andriypyzh.servlets.actions;

import andriypyzh.entity.Project;
import andriypyzh.entity.User;
import andriypyzh.services.ProjectService;
import andriypyzh.services.TaskService;
import org.apache.log4j.Logger;
import org.graalvm.compiler.lir.LIRInstruction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteProject")
public class DeleteProjectServlet extends HttpServlet {
    Logger logger = Logger.getLogger(DeleteTaskServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String section = (String) session.getAttribute("section");
        User user = (User) session.getAttribute("user");

        ProjectService projectService = new ProjectService();
        projectService.removeByName(section,user);

        List<Project> projects = projectService.getAllUsersProjects(user);
        session.setAttribute("projects", projects);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
        requestDispatcher.forward(request, response);

    }
}
