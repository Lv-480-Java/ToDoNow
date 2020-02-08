package andriypyzh.services.authentication;

import andriypyzh.dao.Implementation.UserDao;
import andriypyzh.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;


public class LogInService {
    private static Logger logger = Logger.getLogger(LogInService.class.getName());

    public boolean login(HttpSession session, String username, String password) {
        logger.info("LOGIN " + username);

        UserDao userDao = new UserDao();
        User user = userDao.getByName(username);

        try {
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    logger.info("Successfully logged");
                    //Message
                    session.setAttribute("user", user);
                    return true;
                } else {
                    logger.info("Invalid Password");
                }
            } else {
                //Message
                logger.warn("No such user");
            }
        } catch (RuntimeException e) {
            logger.error("Error during logining", e);
        }
        return false;
    }
}
