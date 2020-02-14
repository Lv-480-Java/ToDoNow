package andriypyzh.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "11111111";
    private static final String CONNNECTION_URL = "jdbc:mysql://localhost:3306";
    private static final String DATABASE_NAME = "USE ToDoList;";
    private static Logger logger = Logger.getLogger(ConnectionFactory.class.getName());
    private static ConnectionFactory DBconnection;
    private Connection connection = null;

    private ConnectionFactory() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(CONNNECTION_URL, USERNAME, PASSWORD);
            logger.info("Connection OK");

            Statement statement = connection.createStatement();
            statement.executeQuery(DATABASE_NAME);
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Problem with db connection", e);
        }
    }

    public static ConnectionFactory getInstance() {
        if (DBconnection == null) {
            DBconnection = new ConnectionFactory();
            return DBconnection;
        } else {
            return DBconnection;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
