package andriypyzh.dao.Implementation;

import andriypyzh.dao.Interfaces.*;
import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskImpl implements TaskDao {


    @Override
    public void add(Task task) {
        String sql = "INSERT INTO Tasks(ID, Name, Owner, ProjectID," +
                "Priority, CreationDate, ExpirationDate, Description, Status) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, task.getId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getOwner());
            statement.setInt(4, task.getProjectId());
            statement.setInt(5, task.getPriority());
            statement.setDate(6, task.getCreationDate());
            statement.setDate(7, task.getExpirationDate());
            statement.setString(8, task.getDescription());
            statement.setString(9, task.getStatus());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Task getById(int id) {
        String sql = "SELECT ID, Name, Owner, ProjectID,Priority, CreationDate, ExpirationDate," +
                " Description, Status FROM Tasks WHERE ID = ?;";

        Task newTask = new Task();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                newTask.setId(resultSet.getInt("ID"));
                newTask.setName(resultSet.getString("Name"));
                newTask.setOwner(resultSet.getString("Owner"));
                newTask.setProjectId(resultSet.getInt("ProjectID"));
                newTask.setPriority(resultSet.getInt("Priority"));
                newTask.setCreationDate(resultSet.getDate("CreationDate"));
                newTask.setExpirationDate(resultSet.getDate("ExpirationDate"));
                newTask.setDescription(resultSet.getString("Description"));
                newTask.setStatus(resultSet.getString("Status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newTask;
    }

    @Override
    public Task getByName(String name) {

        String sql = "SELECT ID, Name, Owner, ProjectID,Priority, CreationDate," +
                " ExpirationDate, Description, Status FROM Tasks WHERE Name = ?;";

        Task newTask = new Task();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                newTask.setId(resultSet.getInt("ID"));
                newTask.setName(resultSet.getString("Name"));
                newTask.setOwner(resultSet.getString("Owner"));
                newTask.setProjectId(resultSet.getInt("ProjectID"));
                newTask.setPriority(resultSet.getInt("Priority"));
                newTask.setCreationDate(resultSet.getDate("CreationDate"));
                newTask.setExpirationDate(resultSet.getDate("ExpirationDate"));
                newTask.setDescription(resultSet.getString("Description"));
                newTask.setStatus(resultSet.getString("Status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newTask;
    }

    @Override
    public List<Task> getAllByUser(User user) {
        return null;
    }

    @Override
    public List<Task> getAllByProject(int projectId) {
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT ID, Name, Owner, ProjectID,Priority, CreationDate, ExpirationDate," +
                " Description, Status FROM Tasks WHERE ProjectID = ?;";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Task newTask = new Task();
                newTask.setId(resultSet.getInt("ID"));
                newTask.setName(resultSet.getString("Name"));
                newTask.setOwner(resultSet.getString("Owner"));
                newTask.setProjectId(resultSet.getInt("ProjectID"));
                newTask.setPriority(resultSet.getInt("Priority"));
                newTask.setCreationDate(resultSet.getDate("CreationDate"));
                newTask.setExpirationDate(resultSet.getDate("ExpirationDate"));
                newTask.setDescription(resultSet.getString("Description"));
                newTask.setStatus(resultSet.getString("Status"));

                tasks.add(newTask);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public void update(Task task) {
        String sql = "UPDATE Tasks SET Name = ?, Owner = ?, ProjectID = ?,Priority= ?," +
                " CreationDate = ?, ExpirationDate = ?, Description =?, Status = ? WHERE ID = ?;";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, task.getName());
            statement.setString(2, task.getOwner());
            statement.setInt(3, task.getProjectId());
            statement.setInt(4, task.getPriority());
            statement.setDate(5, task.getCreationDate());
            statement.setDate(6, task.getExpirationDate());
            statement.setString(7, task.getDescription());
            statement.setString(8, task.getStatus());
            statement.setInt(9, task.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM Tasks WHERE ID = ?;";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TaskImpl taskImpl = new TaskImpl();

        Task task1 = new Task(0, "task1", "ilon", 1, 3,
                new Date(1000L), new Date(1000L), "hello world", "Created");
        Task task2 = new Task(1, "task2","ilon" , 1 , 3,
                new Date(1000L), new Date(1000L), "hello world", "Created");
        Task task3 = new Task(2, "task3", "ilon", 1, 3,
                new Date(1000L), new Date(1000L), "hello world", "Created");

        taskImpl.add(task1);
        taskImpl.add(task2);
        taskImpl.add(task3);

        System.out.println(taskImpl.getById(0));
        System.out.println(taskImpl.getById(1));
        System.out.println(taskImpl.getById(2));

        System.out.println(taskImpl.getByName("task1"));
        System.out.println(taskImpl.getByName("task2"));
        System.out.println(taskImpl.getByName("task3"));

        System.out.println(taskImpl.getAllByProject(1));


//        System.out.println(taskImpl.getByName("task1"));

        taskImpl.remove(0);
        taskImpl.remove(1);
        taskImpl.remove(2);

    }
}
