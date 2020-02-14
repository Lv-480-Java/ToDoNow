package andriypyzh.services.authentication;

import andriypyzh.dao.Implementation.UserDao;
import andriypyzh.entity.User;
import andriypyzh.services.validators.UserValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;

public class LogInService {
    private static Logger logger = Logger.getLogger(LogInService.class.getName());

    public boolean login(HttpSession session, String username, String password) {
        logger.info("LOGIN " + username);

        UserDao userDao = new UserDao();
        User user = userDao.getByName(username);
        UserValidator userValidator = new UserValidator();

        userValidator.loginValidation(username, password);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                logger.info("Successfully logged");
                session.setAttribute("user", user);
                return true;
            } else {
                logger.info("Invalid Password");
                throw new IllegalArgumentException("Invalid Password");
            }
        } else {
            logger.info("No such user");
            throw new IllegalArgumentException("No such user");
        }
    }
}
