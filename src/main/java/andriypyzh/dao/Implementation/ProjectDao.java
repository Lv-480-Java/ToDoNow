package andriypyzh.dao.Implementation;

import andriypyzh.entity.Project;
import andriypyzh.entity.User;
import andriypyzh.util.ConnectionFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.phases.LIRSuites;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProjectDao extends GenericDao<Project> {

    private static final Logger logger = LogManager.getLogger(ProjectDao.class);


    private static final String ADD = "INSERT INTO Projects( Name, Creator, CreationDate," +
            " ExpirationDate, Description, Status, Type) VALUES (?,?,?,?,?,?,?)";
    private static final String GET_BY_ID = "SELECT ID, Name, Creator, CreationDate, ExpirationDate," +
            " Description, Status, Type FROM Projects WHERE ID = ?;";
    private static final String GET_BY_NAME = "SELECT ID, Name, Creator, CreationDate, ExpirationDate," +
            " Description, Status, Type FROM Projects WHERE Name = ?;";
    private static final String GET_ALL_BY_USER = "SELECT Projects.ID, Projects.Name, Projects.Creator, " +
            " Projects.CreationDate, Projects.ExpirationDate, " +
            " Projects.Description, Projects.Status, Projects.Type " +
            " FROM Projects INNER JOIN Users_Projects_Assigments " +
            " ON Users_Projects_Assigments.ProjectID = Projects.ID" +
            " INNER JOIN Users ON Users_Projects_Assigments.UserID = Users.ID" +
            " WHERE Users.Username = ?;";

    private static final String GET_ASSIGNED_USERS = "SELECT Users.Username"+
            " FROM Projects INNER JOIN Users_Projects_Assigments"+
            " ON Users_Projects_Assigments.ProjectID = Projects.ID INNER JOIN Users"+
            " ON Users_Projects_Assigments.UserID = Users.ID"+
            " WHERE ProjectID = ?;";
    private static final String REMOVE_BY_ID = "DELETE FROM Projects WHERE ID = ?;";
    private static final String ASSIGN_USER = "INSERT INTO Users_Projects_Assigments(UserID, ProjectID) VALUES (?,?);";
    private static final String UPDATE = "UPDATE Projects SET Name=?, Creator=?,CreationDate=?," +
            "ExpirationDate=?, Description=?, Status=?, Type=? WHERE ID = ?;";
    private static final String UNASSIGN_USER = "DELETE FROM Users_Projects_Assigments WHERE UserID = ? AND ProjectID = ? ;";



    @Override
    public void add(Project project) {
        logger.info("Project Add");
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(ADD)) {

            statement.setString(1, project.getName());
            statement.setString(2, project.getCreator());
            statement.setDate(3, project.getCreationDate());
            statement.setDate(4, project.getExpirationDate());
            statement.setString(5, project.getDescription());
            statement.setString(6, project.getStatus());
            statement.setString(7, project.getType());

            logger.info(statement.toString());

            statement.execute();
        } catch (SQLException e) {
            logger.error("Project Insertion Error", e);
        }
    }

    @Override
    public Project getById(int id) {
        logger.info("Project Get By Id");

        Project newProject = new Project();

        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {

            statement.setInt(1, id);

            logger.info(statement.toString());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                newProject.setId(resultSet.getInt("ID"));
                newProject.setName(resultSet.getString("Name"));
                newProject.setCreator(resultSet.getString("Creator"));
                newProject.setCreationDate(resultSet.getDate("CreationDate"));
                newProject.setExpirationDate(resultSet.getDate("ExpirationDate"));
                newProject.setDescription(resultSet.getString("Description"));
                newProject.setStatus(resultSet.getString("Status"));
                newProject.setType(resultSet.getString("Type"));
            }
        } catch (SQLException e) {
            logger.error("Get Project by id Error", e);
        }
        return newProject;
    }


    @Override
    public Project getByName(String name) {
        logger.info("Project Get By Name");

        Project newProject = new Project();

        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_BY_NAME)) {

            statement.setString(1, name);

            logger.info(statement.toString());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                newProject.setId(resultSet.getInt("ID"));
                newProject.setName(resultSet.getString("Name"));
                newProject.setCreator(resultSet.getString("Creator"));
                newProject.setCreationDate(resultSet.getDate("CreationDate"));
                newProject.setExpirationDate(resultSet.getDate("ExpirationDate"));
                newProject.setDescription(resultSet.getString("Description"));
                newProject.setStatus(resultSet.getString("Status"));
                newProject.setType(resultSet.getString("Type"));
            }

        } catch (SQLException e) {
            logger.error("Get Project by Name Error", e);
        }
        return newProject;
    }

    public List<String> getAllAssignedUsers(Project project){
        logger.info("Project Get By User");

        List<String> usernames = new ArrayList<>();

        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_ASSIGNED_USERS)) {

            statement.setInt(1, project.getId());

            logger.info(statement.toString());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                usernames.add(resultSet.getString("Username"));
            }
        } catch (SQLException e){
            logger.error("Get Assigned Users error",e);
        }
        return usernames;
    }

    public List<Project> getAllByUser(User user) {
        logger.info("Project Get By User");

        List<Project> projects = new ArrayList<>();

        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_BY_USER)) {

            statement.setString(1, user.getUsername());

            logger.info(statement.toString());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Project newProject = new Project();

                newProject.setId(resultSet.getInt("ID"));
                newProject.setName(resultSet.getString("Name"));
                newProject.setCreator(resultSet.getString("Creator"));
                newProject.setCreationDate(resultSet.getDate("CreationDate"));
                newProject.setExpirationDate(resultSet.getDate("ExpirationDate"));
                newProject.setDescription(resultSet.getString("Description"));
                newProject.setStatus(resultSet.getString("Status"));
                newProject.setType(resultSet.getString("Type"));

                projects.add(newProject);
            }
        } catch (SQLException e) {
            logger.error("Get Project By User Error", e);
        }
        return projects;
    }

    @Override
    public void update(Project project) {
        logger.info("Project Update");
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            logger.info(statement.toString());

            statement.setString(1, project.getName());
            statement.setString(2, project.getCreator());
            statement.setDate(3, project.getCreationDate());
            statement.setDate(4, project.getExpirationDate());
            statement.setString(5, project.getDescription());
            statement.setString(6, project.getStatus());
            statement.setString(7, project.getType());
            statement.setInt(8, project.getId());


            statement.execute();
        } catch (SQLException e) {
            logger.error("Project Update Error", e);
        }
    }

    @Override
    public void removeById(int id) {
        logger.info("Project Remove By Id");
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(REMOVE_BY_ID)) {

            statement.setInt(1, id);
            logger.info(statement.toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            logger.info("Remove Project Error", e);
        }
    }

    public void assignUser(Project project, User user) {
        logger.info("Assign User");
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(ASSIGN_USER)) {
            System.out.println(statement.toString());
            statement.setInt(1, user.getId());
            statement.setInt(2, project.getId());

            logger.info(statement.toString());

            statement.execute();

        } catch (SQLException e) {
            logger.info("Assign user Error", e);

        }
    }

    public void unassignUser(Project project, User user){
        logger.info("Unassign User");
        Connection connection = ConnectionFactory.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UNASSIGN_USER)) {
            System.out.println(statement.toString());

            statement.setInt(1, user.getId());
            statement.setInt(2, project.getId());

            logger.info(statement.toString());

            statement.execute();

        } catch (SQLException e) {
            logger.info("Unassign user Error", e);

        }
    }

    public static void main(String[] args) {

         ProjectDao projectDao = new ProjectDao();
         UserDao userDao = new UserDao();
         projectDao.assignUser(projectDao.getById(6),userDao.getById(9));

    }
}
