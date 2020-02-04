package andriypyzh.servlets;

import andriypyzh.entity.Task;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    Logger logger = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        List<Task> tasks = new ArrayList<>();
        HttpSession session = request.getSession();
        logger.info((String) session.getAttribute("user"));

    }

}
