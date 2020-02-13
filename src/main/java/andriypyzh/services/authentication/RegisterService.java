package andriypyzh.services.authentication;

import andriypyzh.dao.Implementation.ProjectDao;
import andriypyzh.dao.Implementation.UserDao;
import andriypyzh.entity.Project;
import andriypyzh.entity.User;
import andriypyzh.services.validators.UserValidator;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.Calendar;

public class RegisterService {
    private static Logger logger = Logger.getLogger(RegisterService.class.getName());

    public void registerUser(String username, String password, String confirmPassword) {
        logger.info("REGISTER " + username);

        UserDao userDao = new UserDao();
        ProjectDao projectDao = new ProjectDao();
        UserValidator validator = new UserValidator();

        try {
            validator.registerValidation(username,password,confirmPassword);

            User user = new User(username, password);
            userDao.add(user);

            Calendar calendar = Calendar.getInstance();
            java.sql.Date creationDate = new java.sql.Date(calendar.getTime().getTime());

            Project project = new Project(0, "Tasks of " + username, username,
                    creationDate, new Date(1000L), "", "in procces", "default");

            projectDao.add(project);

            projectDao.assignUser(projectDao.getByName("Tasks of " + username),
                                  userDao.getByName(user.getUsername()));
        }
        catch (IllegalArgumentException e){
            logger.error(e);
            throw e;
        }

        catch (RuntimeException e) {
            logger.error("Registration Failed", e);
            throw e;
        }
    }
}
