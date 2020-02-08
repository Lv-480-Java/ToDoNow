package andriypyzh.services.authentication;

import andriypyzh.dao.Implementation.ProjectDao;
import andriypyzh.dao.Implementation.UserDao;
import andriypyzh.entity.Project;
import andriypyzh.entity.User;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.Calendar;

public class RegisterService {
    private static Logger logger = Logger.getLogger(RegisterService.class.getName());

    public boolean registerUser(String username, String password, String confirmPassword) {
        logger.info("REGISTER " + username);

        UserDao userDao = new UserDao();
        ProjectDao projectDao = new ProjectDao();

        //
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            logger.info("Invalid Data");
        } else if (!password.equals(confirmPassword)) {
            logger.info("Password doesn't match");

        } else {

            try {
                User user = new User(username, password);
                userDao.add(user);

                Calendar calendar = Calendar.getInstance();
                java.sql.Date creationDate = new java.sql.Date(calendar.getTime().getTime());

                Project project = new Project(0, "Private Tasks of " + username, username,
                        creationDate, new Date(1000L), "", "in procces", "default");

                projectDao.add(project);

                projectDao.assignUser(projectDao.getByName("Private Tasks of " + username),
                        userDao.getByName(user.getUsername()));

                return true;
            } catch (RuntimeException e) {
                logger.error("Registration Failed",e);
            }
        }
        return false;
    }
}
