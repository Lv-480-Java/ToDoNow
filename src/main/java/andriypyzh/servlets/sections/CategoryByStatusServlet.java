package andriypyzh.servlets.sections;

import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.services.ProjectService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/CategoryStatus")
public class CategoryByStatusServlet extends HttpServlet {
    Logger logger = Logger.getLogger(CategoryByStatusServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String status = request.getParameter("status").replace("+"," ");

        ProjectService projectService = new ProjectService();


        try {
            List<Task> tasks = projectService.getTasksByStatusOfUser(user);
            tasks = tasks.stream().filter((x)->x.getStatus().equals(status))
                                  .collect(Collectors.toList());

            request.setAttribute("tasks",tasks);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("status.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            logger.error(e);
        }


    }


}
