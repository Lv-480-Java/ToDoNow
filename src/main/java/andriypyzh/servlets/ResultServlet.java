package andriypyzh.servlets;

import andriypyzh.services.UserService;

import javax.servlet.http.HttpServlet;
import java.util.logging.Logger;

public class ResultServlet extends HttpServlet {

    Logger logger = Logger.getLogger(RegisterServlet.class.getName());
    private UserService userService = new UserService();



}
