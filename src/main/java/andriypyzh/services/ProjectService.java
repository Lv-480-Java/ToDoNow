package andriypyzh.services;

import andriypyzh.dao.Implementation.ProjectDao;
import andriypyzh.dao.Implementation.TaskDao;
import andriypyzh.dao.Implementation.UserDao;
import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import org.apache.log4j.Logger;

import javax.persistence.PostLoad;
import javax.persistence.criteria.Predicate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class ProjectService {
    Logger logger = Logger.getLogger(ProjectService.class);

    private ProjectDao projectDao = new ProjectDao();
    private TaskDao taskDao = new TaskDao();
    private UserDao userDao = new UserDao();


    public void updateProject(int id, String projectName, Date deadline, String description, String type) {
        Project newProject = projectDao.getById(id);

        newProject.setName(projectName);
        newProject.setExpirationDate(deadline);
        newProject.setDescription(description);
        newProject.setType(type);

        projectDao.update(newProject);
    }

    public void createProject(String projectName, User user,
                              Date deadline, String description, String type) {

        logger.info(user.getUsername() + " Creating Project " + projectName);

        long millis = System.currentTimeMillis();
        java.sql.Date creationDate = new java.sql.Date(millis);

        Project project = new Project(projectName, user.getUsername(), creationDate,
                deadline, description, "created", type);

        projectDao.add(project);

        projectDao.assignUser(projectDao.getByName(projectName), user);
    }

    public Project getUsersProject(User user, String projectName) {

        List<Project> projects = projectDao.getAllByUser(user);

        Project project = projects.stream()
                .filter((x) -> x.getName().equals(projectName))
                .findAny()
                .orElse(null);

        if (project == null) {
            logger.error("No such Project");
            throw new NullPointerException("No such project");
        }

        return project;
    }

    public List<Task> getProjectTasks(User user, String projectName) throws Exception {

        Project project = getUsersProject(user, projectName);

        return taskDao.getAllByProject(project.getId());
    }


    public List<Project> getAllUsersProjects(User user) {

        List<Project> projects = projectDao.getAllByUser(user);

        return projects;
    }

    public List<Task> getTasksByStatusOfUser(User user) throws Exception {
        List<Project> projects = getAllUsersProjects(user);
        List<Task> tasks = new ArrayList<>();

        for (Project project : projects) {
            List<Task> projectTasks = getProjectTasks(user, project.getName());
            tasks.addAll(projectTasks);
        }
        return tasks;
    }

    public Project getByName(String projectName) {
        return projectDao.getByName(projectName);
    }

    public void removeByName(String projectName,User user) {
        Project project = getByName(projectName);
        projectDao.unassignUser(project,user);
        projectDao.removeById(project.getId());
    }

    public List<String> getAssignedUsers(Project project){
        return projectDao.getAllAssignedUsers(project);
    }

    public List<String> getNotAssignedUsers(Project project){
        List<String> assignedUsernames = getAssignedUsers(project);
        List<String> usernames = userDao.getAll().stream()
                .filter(user -> !assignedUsernames.contains(user.getUsername()))
                .map(User::getUsername)
                .collect(Collectors.toList());
        return usernames;
    }

    public void assignUserToProject(User user,Project project){
        projectDao.assignUser(project,user);
    }
    public void unassignUserToProject(User user,Project project){
        projectDao.unassignUser(project,user);
    }
}
