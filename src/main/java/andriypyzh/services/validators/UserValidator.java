package andriypyzh.services.validators;

import andriypyzh.dao.Implementation.UserDao;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import org.apache.log4j.Logger;


public class UserValidator {
    Logger logger = Logger.getLogger(UserValidator.class);

    public void validate() {

    }

    public boolean registerValidation(String username, String password, String confirmPassword) {
        UserDao userDao = new UserDao();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            throw new IllegalArgumentException("Empty field");
        }
        if (!username.matches("[A-Za-z0-9_]+")) {
            throw new IllegalArgumentException("Illegal username");
        }
        if (userDao.getByName(username) != null) {
            throw new IllegalArgumentException("Username is exist");
        }
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords not match");
        }
        return true;
    }

    public boolean loginValidation(String username, String password){
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Empty field");
        }
        return true;
    }


    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.getByName("andriy"));
    }

}
