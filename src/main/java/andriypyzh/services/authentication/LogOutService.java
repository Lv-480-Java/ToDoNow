package andriypyzh.services.authentication;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;


public class LogOutService {
    private static Logger logger = Logger.getLogger(LogOutService.class.getName());

    public boolean logout(HttpSession session) {
        logger.info("LOGOUT");
        try {
            if (session.getAttribute("user") != null) {
                //Message
                logger.info("User = " + session.getAttribute("user"));
            } else {
                //Message
                logger.warn("User object is null");
            }
            session.invalidate();
            return true;
        } catch (NullPointerException e) {
            logger.error("Session is not established", e);
        }
        return false;
    }
}
