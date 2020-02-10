package andriypyzh.services;


import andriypyzh.dao.Implementation.ProjectDao;
import andriypyzh.dao.Implementation.TaskDao;
import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import org.apache.log4j.Logger;

import javax.persistence.criteria.Predicate;
import javax.sound.midi.MidiFileFormat;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ProjectService {
    Logger logger = Logger.getLogger(ProjectService.class);


    public void updateProject(int id,String projectName, Date deadline, String description,String type){

        ProjectDao projectDao = new ProjectDao();
        Project newProject = projectDao.getById(id);

        newProject.setName(projectName);
        newProject.setExpirationDate(deadline);
        newProject.setDescription(description);
        newProject.setType(type);

        projectDao.update(newProject);
    }

    public void createProject(String projectName, User user,
                              Date deadline, String description, String type) {

        logger.info(user.getUsername() + " Creating Project "+projectName);

        long millis = System.currentTimeMillis();
        java.sql.Date creationDate = new java.sql.Date(millis);

        ProjectDao projectDao = new ProjectDao();

        Project project = new Project(projectName, user.getUsername(), creationDate,
                deadline, description,"created",type);

        projectDao.add(project);

        projectDao.assignUser(projectDao.getByName(projectName),user);


    }

    public Project getUsersProject(User user, String projectName) {
        ProjectDao projectDao = new ProjectDao();

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
        TaskDao taskDao = new TaskDao();

        Project project = getUsersProject(user, projectName);

        return taskDao.getAllByProject(project.getId());
    }


    public List<Project> getAllUsersProjects(User user) {
        ProjectDao projectDao = new ProjectDao();

        List<Project> projects = projectDao.getAllByUser(user);

        return projects;
    }
}
