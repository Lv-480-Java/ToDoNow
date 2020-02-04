package andriypyzh.dao.Interfaces;

import andriypyzh.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    //create
    void add(User user);

    //read
    User getById(int id);
    User getByName(String name);
    List<User> getAll();


    //update
    void update(User user);

    //delete
    void removeById(int id);
}
