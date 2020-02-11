package andriypyzh.servlets.actions;

import andriypyzh.dao.Implementation.ProjectDao;

import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AssignUserServlet extends HttpServlet {
    Logger logger = Logger.getLogger(AssignUserServlet.class);


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        ProjectDao projectDao = new ProjectDao();



    }

}
