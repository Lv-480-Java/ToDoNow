package andriypyzh.servlets;

import andriypyzh.dao.Implementation.UserImpl;
import andriypyzh.entity.User;
import andriypyzh.services.UserService;

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
    private UserService userService = new UserService();
    private HttpServletRequest request;

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

        UserImpl userImpl = new UserImpl();

        if (userService.logInUser(user)){
            HttpSession session = request.getSession();
            session.setAttribute("user",userImpl.getByName(username));
            logger.info("Session created");

            request.setAttribute("user",user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home");
            requestDispatcher.forward(request, response);

        }else {
            response.sendRedirect("error_aut");
        }
//        response.setStatus(401);
    }

//    private LoginDao loginDao;
//
//    public void init() {
//        loginDao = new LoginDao();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.sendRedirect("login/login.jsp");
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        authenticate(request, response);
//    }
//
//    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        LoginBean loginBean = new LoginBean();
//        loginBean.setUsername(username);
//        loginBean.setPassword(password);
//
//        try {
//            if (loginDao.validate(loginBean)) {
//                RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
//                dispatcher.forward(request, response);
//            } else {
//                HttpSession session = request.getSession();
//                // session.setAttribute("user", username);
//                // response.sendRedirect("login.jsp");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
}
