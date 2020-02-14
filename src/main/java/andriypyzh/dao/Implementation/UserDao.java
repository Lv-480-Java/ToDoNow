package andriypyzh.dao.Implementation;

import andriypyzh.entity.User;
import andriypyzh.dao.ConnectionFactory;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends GenericDao<User> {
    private static final String ADD = "INSERT INTO Users(Username, Password) VALUES (?,?);";
    private static final String GET_BY_ID = "SELECT ID,Username,Password FROM Users WHERE ID = ?;";
    private static final String GET_BY_NAME = "SELECT ID,Username,Password FROM Users WHERE Username = ?;";
    private static final String GET_ALL = "SELECT ID,Username,Password FROM Users;";
    private static final String UPDATE = "UPDATE Users SET Username = ?, Password = ? WHERE ID = ?;";
    private static final String REMOVE_BY_ID = "DELETE FROM Users WHERE ID = ?;";
    Logger logger = Logger.getLogger(UserDao.class.getName());

    @Override
    public void add(User user) {
        logger.info("User Add");
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            logger.info(statement.toString());

            statement.execute();
        } catch (SQLException e) {
            logger.error("User Insertion Error", e);
        }
    }

    @Override
    public User getById(int id) {
        logger.info("User Get By ID");
        Connection connection = ConnectionFactory.getInstance().getConnection();

        User newUser = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {

            statement.setString(1, String.valueOf(id));

            logger.info(statement.toString());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                newUser = new User();
                newUser.setId(resultSet.getInt("ID"));
                newUser.setUsername(resultSet.getString("Username"));
                newUser.setPassword(resultSet.getString("Password"));
            }

        } catch (SQLException e) {
            logger.error("User Get By ID Error", e);
        }
        return newUser;
    }

    @Override
    public User getByName(String name) {
        logger.info("User Get By Name");

        Connection connection = ConnectionFactory.getInstance().getConnection();
        User newUser = null;

        try (PreparedStatement statement = connection.prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);

            logger.info(statement.toString());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                newUser = new User();

                newUser.setId(resultSet.getInt("ID"));
                newUser.setUsername(resultSet.getString("Username"));
                newUser.setPassword(resultSet.getString("Password"));
            }

        } catch (SQLException e) {
            logger.error("User Get By Name Error", e);
        }
        return newUser;
    }


    public List<User> getAll() {
        logger.info("User Get All");

        List<User> users = new ArrayList<>();
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(GET_ALL);
            logger.info(GET_ALL);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setUsername(resultSet.getString("Username"));
                user.setPassword(resultSet.getString("Password"));

                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("User Get All", e);
        }
        return users;
    }

    @Override
    public void update(User user) {
        logger.info("User Update");
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());

            logger.info(statement.toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("User Updating Error", e);
        }
    }

    @Override
    public void removeById(int id) {
        logger.info("User Remove by ID");
        Connection connection = ConnectionFactory.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_BY_ID)) {
            statement.setInt(1, id);

            logger.info(statement.toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("User Removing Error", e);
        }
    }
}


