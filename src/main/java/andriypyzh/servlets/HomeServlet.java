package andriypyzh.servlets;

import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.services.TaskService;
import andriypyzh.servlets.authentication.RegisterServlet;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

        List<Task> tasks = new ArrayList<>();
        HttpSession session = request.getSession();
        logger.info(session.getAttribute("user").toString());

        TaskService taskService = new TaskService();

        try {
            User user = (User) session.getAttribute("user");
            tasks = taskService.displayTasks(user);

            request.setAttribute("tasks", tasks);
            session.setAttribute("section", "Private Tasks of " + user.getUsername());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/homepage");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/authentication");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
