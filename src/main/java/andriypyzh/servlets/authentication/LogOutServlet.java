package andriypyzh.servlets.authentication;

import andriypyzh.services.authentication.LogOutService;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(LogOutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        LogOutService logoutService = new LogOutService();

        logoutService.logout(request.getSession());
        response.sendRedirect("/authentication");
    }
}
