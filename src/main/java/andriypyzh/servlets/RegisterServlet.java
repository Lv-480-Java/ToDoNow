package andriypyzh.servlets;

import andriypyzh.entity.User;
import andriypyzh.services.UserService;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    Logger logger = Logger.getLogger(RegisterServlet.class.getName());
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info(RegisterServlet.class.getName() + " called post");
        logger.info(String.valueOf(request));

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm password");

        if (!password.equals(confirmPassword)) {
            response.setStatus(422);
            logger.info("Invalid Password");
            response.sendRedirect("error");
        }
        else {

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            UserService userService = new UserService();

            userService.registerUser(user);

            response.sendRedirect("registered");
        }
    }
}