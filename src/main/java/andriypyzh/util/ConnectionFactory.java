package andriypyzh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static Logger logger = Logger.getLogger(ConnectionFactory.class.getName());

    private static final String username = "root";
    private static final String password = "11111111";
    private static final String connnectionURL = "jdbc:mysql://localhost:3306";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connnectionURL, username, password);
            logger.info("Connection OK");

            Statement statement = connection.createStatement();
            statement.executeQuery("USE ToDoList;");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            logger.info("Connection ERROR");
        }
        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }

}
