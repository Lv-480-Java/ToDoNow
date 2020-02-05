package andriypyzh.services;

import andriypyzh.dao.Implementation.ProjectImpl;
import andriypyzh.dao.Implementation.UserImpl;
import andriypyzh.entity.Project;
import andriypyzh.entity.User;

import java.time.LocalDate;
import java.sql.Date;
import java.util.logging.Logger;



public class UserService  {

    Logger logger = Logger.getLogger(UserService.class.getName());

    public void registerUser(User user) {
        UserImpl userDao = new UserImpl();
        userDao.add(user);
        ProjectImpl projectDao = new ProjectImpl();
        Project project = new Project(0,"default"+user.getUsername(),user.getUsername(),new
                Date(1L),new Date(1L),"default","default","default");
        projectDao.add(project);
        projectDao.assignUser(projectDao.getByName("default"+user.getUsername()),userDao.getByName(user.getUsername()));
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


