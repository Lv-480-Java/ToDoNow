package andriypyzh.servlets.authentication;

import andriypyzh.services.authentication.LogInService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;


@WebServlet("/LoginServlet")
public class LogInServlet extends HttpServlet {
    Logger logger = Logger.getLogger(RegisterServlet.class.getName());
    private HttpServletRequest request;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info(RegisterServlet.class.getName() + " called post");
        logger.info(String.valueOf(request));

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LogInService logInService = new LogInService();
        HttpSession session = request.getSession();

        try {
            logInService.login(session, username, password);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
            requestDispatcher.forward(request, response);
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("authentication.jsp");
            requestDispatcher.forward(request, response);
        }

    }

}
