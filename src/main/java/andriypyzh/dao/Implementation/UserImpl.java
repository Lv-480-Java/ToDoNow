package andriypyzh.dao.Implementation;

import andriypyzh.dao.Interfaces.UserDao;
import andriypyzh.entity.User;
import andriypyzh.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserImpl implements UserDao {

    Logger logger = Logger.getLogger(UserImpl.class.getName());

    @Override
    public void add(User user) {

        String sql = "INSERT INTO Users(ID,Username, Password) VALUES (?,?,?);";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT ID,Username,Password FROM Users WHERE ID = ?;";

        User newUser = new User();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, String.valueOf(id));

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                newUser.setId(resultSet.getInt("ID"));
                newUser.setUsername(resultSet.getString("Username"));
                newUser.setPassword(resultSet.getString("Password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }

    @Override
    public User getByName(String name) {
        String sql = "SELECT ID,Username,Password FROM Users WHERE Username = ?;";

        User newUser = new User();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                newUser.setId(resultSet.getInt("ID"));
                newUser.setUsername(resultSet.getString("Username"));
                newUser.setPassword(resultSet.getString("Password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser;
    }


    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT ID,Username,Password FROM Users;";

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setUsername(resultSet.getString("Username"));
                user.setPassword(resultSet.getString("Password"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE Users SET Username = ?, Password = ? WHERE ID = ?;";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeById(int id) {
        String sql = "DELETE FROM Users WHERE ID = ?;";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserImpl userService = new UserImpl();


        User user1 = new User(1, "Ilon Mask", "1234");
        User user2 = new User(2, "Jeff Besos", "0000");
        User user3 = new User(3, "Bill Gates", "1111");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);


        System.out.println(userService.getById(2));

        System.out.println(userService.getByName("Bill Gates"));

        userService.update(new User(3, "Bill Gates", "3333"));


        for (User u : userService.getAll()) {
            System.out.println(u);
        }
        userService.removeById(1);
        userService.removeById(2);
        userService.removeById(3);

    }
}


