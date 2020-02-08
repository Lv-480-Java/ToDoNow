package andriypyzh.servlets.authentication;

import andriypyzh.services.authentication.RegisterService;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
        registerService.registerUser(username,password,confirmPassword);

        request.setAttribute("user",username);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("registered.jsp");
        requestDispatcher.forward(request, response);
    }
}