package andriypyzh.services;

import andriypyzh.dao.Implementation.ProjectDao;
import andriypyzh.dao.Implementation.TaskDao;
import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TaskService {
    Logger logger = Logger.getLogger(TaskService.class);

    public Task getByID(int id){
        TaskDao taskDao = new TaskDao();
        return taskDao.getById(id);
    }

    public void updateTask(int id, String name, int priority,
                           Date deadline,String description) {

        TaskDao taskDao = new TaskDao();
        Task newTask = taskDao.getById(id);
        newTask.setName(name);
        newTask.setPriority(priority);
        newTask.setExpirationDate(deadline);
        newTask.setDescription(description);

        taskDao.update(newTask);
    }

    public void createTask(String name, String username, String project,
                           int priority, Date deadline, String description) {

        logger.info(username + " Creating Task " + name);

        long millis = System.currentTimeMillis();
        java.sql.Date creationDate = new java.sql.Date(millis);

        ProjectDao projectDao = new ProjectDao();

        Task task = new Task(name, username, projectDao.getByName(project).getId(), priority,
                creationDate, deadline, description, "created");

        TaskDao taskDao = new TaskDao();
        taskDao.add(task);
    }


    public List<Task> displayTasks(User user) throws Exception {
        TaskDao taskDao = new TaskDao();
        ProjectDao projectDao = new ProjectDao();

        try {
            List<Project> projects = projectDao.getAllByUser(user);
            for (Project project : projects) {
                System.out.println(project.getType());
                if (project.getName().equals("Private Tasks of " + user.getUsername())) {
                    return taskDao.getAllByProject(project.getId());
                }
            }
        } catch (Exception e) {
            logger.error("Cannot display tasks", e);
        }
        return new ArrayList<Task>();
    }

    public List<Task> displayTasksByProject(Project project) throws Exception {
        TaskDao taskDao = new TaskDao();
        ProjectDao projectDao = new ProjectDao();

        try {
            List<Task> projects = taskDao.getAllByProject(project.getId());
        } catch (Exception e) {
            logger.error("Cannot display tasks", e);
        }

        return new ArrayList<Task>();
    }


}
