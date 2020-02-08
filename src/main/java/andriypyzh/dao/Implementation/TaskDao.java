package andriypyzh.dao.Implementation;

import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.util.ConnectionFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao extends GenericDao<Task> {
    private static final Logger logger = LogManager.getLogger(ProjectDao.class);

    private static final String ADD = "INSERT INTO Tasks( Name, Owner, ProjectID," +
            "Priority, CreationDate, ExpirationDate, Description, Status) " +
            "VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_BY_ID = "SELECT ID, Name, Owner, ProjectID,Priority, CreationDate, ExpirationDate," +
            " Description, Status FROM Tasks WHERE ID = ?;";
    private static final String GET_BY_NAME = "SELECT ID, Name, Owner, ProjectID,Priority, CreationDate," +
            " ExpirationDate, Description, Status FROM Tasks WHERE Name = ?;";
    private static final String GET_BY_USER = "SELECT ID, Name, Owner, ProjectID,Priority, CreationDate, ExpirationDate," +
            " Description, Status FROM Tasks WHERE Owner= ?;";
    private static final String GET_BY_PROJECT = "SELECT ID, Name, Owner, ProjectID,Priority, CreationDate, ExpirationDate," +
            " Description, Status FROM Tasks WHERE ProjectID = ?;";
    private static final String UPDATE = "UPDATE Tasks SET Name = ?, Owner = ?, ProjectID = ?,Priority= ?," +
            " CreationDate = ?, ExpirationDate = ?, Description =?, Status = ? WHERE ID = ?;";
    private static final String REMOVE_BY_ID = "DELETE FROM Tasks WHERE ID = ?";


    @Override
    public void add(Task task) {
        logger.info("Task Add");

        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setString(1, task.getName());
            statement.setString(2, task.getOwner());
            statement.setInt(3, task.getProjectId());
            statement.setInt(4, task.getPriority());
            statement.setDate(5, task.getCreationDate());
            statement.setDate(6, task.getExpirationDate());
            statement.setString(7, task.getDescription());
            statement.setString(8, task.getStatus());

            logger.info(statement.toString());

            statement.execute();
        } catch (SQLException e) {
            logger.error("Task Insertion Error", e);
        }
    }

    @Override
    public Task getById(int id) {
        logger.info("Task Get By ID");
        Task newTask = new Task();
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {

            statement.setInt(1, id);

            logger.info(statement.toString());

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
            logger.error("Task Get By ID Error", e);
        }
        return newTask;
    }

    @Override
    public Task getByName(String name) {
        logger.info("Task Get By Name");
        Task newTask = new Task();

        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_BY_NAME)) {

            statement.setString(1, name);

            logger.info(statement.toString());

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
            logger.error("Task Get By Name Error", e);
        }
        return newTask;
    }

    public List<Task> getAllByUser(User user) {
        logger.info("Task Get By User");
        List<Task> tasks = new ArrayList<>();

        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_BY_USER)) {

            statement.setString(1, user.getUsername());

            logger.info(statement.toString());

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
            logger.error("Task Get By User Error", e);
        }
        return tasks;
    }

    public List<Task> getAllByProject(int projectId) {
        logger.info("Task Get By Project");
        List<Task> tasks = new ArrayList<>();

        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_BY_PROJECT)) {
            statement.setInt(1, projectId);
            logger.info(statement.toString());

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
            logger.error("Task Get By Project", e);
        }
        return tasks;
    }

    @Override
    public void update(Task task) {
        logger.info("Task Update");

        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setString(1, task.getName());
            statement.setString(2, task.getOwner());
            statement.setInt(3, task.getProjectId());
            statement.setInt(4, task.getPriority());
            statement.setDate(5, task.getCreationDate());
            statement.setDate(6, task.getExpirationDate());
            statement.setString(7, task.getDescription());
            statement.setString(8, task.getStatus());
            statement.setInt(9, task.getId());

            logger.info(statement.toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Task Update Error", e);
        }
    }

    @Override
    public void removeById(int id) {
        logger.info("Task Remove Id");
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(REMOVE_BY_ID)) {
            statement.setInt(1, id);
            logger.info(statement.toString());
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.info("Task Remove ID", e);
        }
    }

    public static void main(String[] args) {
        TaskDao taskDao = new TaskDao();

        Task task1 = new Task(0, "task1", "ilon", 1, 3,
                new Date(1000L), new Date(1000L), "hello world", "Created");
        Task task2 = new Task(1, "task2", "ilon", 1, 3,
                new Date(1000L), new Date(1000L), "hello world", "Created");
        Task task3 = new Task(2, "task3", "ilon", 1, 3,
                new Date(1000L), new Date(1000L), "hello world", "Created");

        taskDao.add(task1);
        taskDao.add(task2);
        taskDao.add(task3);

        System.out.println(taskDao.getById(0));
        System.out.println(taskDao.getById(1));
        System.out.println(taskDao.getById(2));

        System.out.println(taskDao.getByName("task1"));
        System.out.println(taskDao.getByName("task2"));
        System.out.println(taskDao.getByName("task3"));

        System.out.println(taskDao.getAllByProject(1));


//        System.out.println(taskImpl.getByName("task1"));

        taskDao.removeById(0);
        taskDao.removeById(1);
        taskDao.removeById(2);

    }
}
