package andriypyzh.services;

import andriypyzh.dao.Implementation.UserDao;
import andriypyzh.entity.User;

import java.util.logging.Logger;

public class UserService {
    Logger logger = Logger.getLogger(UserService.class.getName());

    UserDao userDao = new UserDao();

    public User getByUsername(String username) {
        return userDao.getByName(username);
    }

}


