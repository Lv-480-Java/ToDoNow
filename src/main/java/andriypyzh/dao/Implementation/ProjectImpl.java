package andriypyzh.dao.Implementation;

import andriypyzh.dao.Interfaces.*;
import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import andriypyzh.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProjectImpl implements ProjectDao {
    @Override
    public void add(Project project) {
        String sql = "INSERT INTO Projects(ID, Name, CreatorID, CreationDate, ExpirationDate," +
                " Description, Status, Type) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, project.getId());
            statement.setString(2, project.getName());
            statement.setString(3, project.getCreator());
            statement.setDate(4, project.getCreationDate());
            statement.setDate(5, project.getExpirationDate());
            statement.setString(6, project.getDescription());
            statement.setString(7, project.getStatus());
            statement.setString(8, project.getType());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getById(int id) {
        String sql = "SELECT ID, Name, UserID, ProjectID,Priority, CreationDate, ExpirationDate," +
                " Description, Status FROM Tasks WHERE ID = ?;";

        Project newProject = new Project();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

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
            e.printStackTrace();
        }
        return newProject;
    }

    @Override
    public Project getByName(String name) {

        String sql = "SELECT ID, Name, UserID, ProjectID,Priority, CreationDate," +
                " ExpirationDate, Description, Status FROM Tasks WHERE Name = ?;";

        Project newProject = new Project();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);

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
            e.printStackTrace();
        }
        return newProject;
    }

    @Override
    public List<Project> getAllByUser(User user) {
        List<Project> projects = new ArrayList<>();

        String sql = "SELECT Projects.ID, Projects.Name, Projects.Creator, " +
                           " Projects.CreationDate, Projects.ExpirationDate, " +
                           " Projects.Description, Projects.Status, Projects.Type " +
                     " FROM Projects INNER JOIN Users_Projects_Assigments " +
                     " ON Users_Projects_Assigments.ProjectID = Projects.ID" +
                     " INNER JOIN Users on Users_Projects_Assigments.UserID = Users.ID" +
                     " WHERE Users.Username = ?;";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1,user.getUsername() );

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
                newProject.setType("Type");

                projects.add(newProject);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void remove(int id) {

    }
}
