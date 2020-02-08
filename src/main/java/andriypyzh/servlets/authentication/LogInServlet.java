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
        if (logInService.login(session, username, password)) {
            request.setAttribute("user", username);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
            requestDispatcher.forward(request, response);
        } else {
//            response.sendRedirect("error_aut");
            String msg = "Cannot LogIn" + username;

            logger.warning(msg);

            request.setAttribute("msg",msg);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request, response);

        }
    }

}
