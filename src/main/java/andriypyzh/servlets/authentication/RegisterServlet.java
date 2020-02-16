package andriypyzh.servlets.authentication;

import andriypyzh.services.authentication.RegisterService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info(RegisterServlet.class.getName() + " called post");
        logger.info(String.valueOf(request));

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm password");

        RegisterService registerService = new RegisterService();
        try {
            registerService.registerUser(username, password, confirmPassword);

            request.setAttribute("error", "Successfully registered");

            request.setAttribute("user", username);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/authentication/login.jsp");
            requestDispatcher.forward(request, response);
//            response.sendRedirect("/todonow/authentication/login.jsp");

        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            logger.error("Cannot Register", e);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/authentication/register.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}