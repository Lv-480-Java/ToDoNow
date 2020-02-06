package andriypyzh.servlets;

import andriypyzh.dao.Implementation.ProjectImpl;
import andriypyzh.dao.Implementation.TaskImpl;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.services.ProjectService;
import andriypyzh.services.TaskService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("tasklist.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("authentication.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
