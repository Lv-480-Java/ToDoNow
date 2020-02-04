package andriypyzh.services;

import andriypyzh.dao.Implementation.UserImpl;
import andriypyzh.entity.User;


import java.util.logging.Logger;



public class UserService  {

    Logger logger = Logger.getLogger(UserService.class.getName());

    public void registerUser(User user) {
        UserImpl userDao = new UserImpl();
        userDao.add(user);
    }

    public boolean logInUser(User user){
        UserImpl userDao = new UserImpl();

        User loginUser = userDao.getByName(user.getUsername());

        if (loginUser != null && loginUser.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }


}


