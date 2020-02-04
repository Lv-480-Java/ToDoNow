package andriypyzh.dao.Interfaces;

import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;

import javax.persistence.criteria.Predicate;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {

    //create
    void add(Project project);

    //read
    Project getById(int id);
    Project getByName(String name);
    List<Project> getAllByUser(User user);

    //update
    void update(Task task);

    //delete
    void remove(int id);
}
