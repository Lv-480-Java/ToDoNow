package andriypyzh.dao.Interfaces;

import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {

    //create
    void add(Task task);

    //read
    Task getById(int id);
    Task getByName(String name);
    List<Task> getAllByUser(User user);
    List<Task> getAllByProject(int  projectId);


    //update
    void update(Task task);

    //delete
    void remove(int id);

}
