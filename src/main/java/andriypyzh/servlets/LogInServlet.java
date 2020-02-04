package andriypyzh.servlets;

import andriypyzh.entity.User;
import andriypyzh.services.UserService;

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
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info(RegisterServlet.class.getName() + " called post");
        logger.info(String.valueOf(request));

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userService.logInUser(user)){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            logger.info("Session created");
            response.sendRedirect("logged");
        }else {
            response.sendRedirect("error_aut");
        }
//        response.setStatus(401);
    }
}
