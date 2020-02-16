package andriypyzh.services;

import andriypyzh.dao.Implementation.ProjectDao;
import andriypyzh.dao.Implementation.TaskDao;
import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskService {
    Logger logger = Logger.getLogger(TaskService.class);

    TaskDao taskDao = new TaskDao();
    ProjectDao projectDao = new ProjectDao();


    public Task getByID(int id) {
        return taskDao.getById(id);
    }

    public void updateTask(Task oldTask) {

        Task newTask = taskDao.getById(oldTask.getId());
        newTask.setName(oldTask.getName());
        newTask.setPriority(oldTask.getPriority());
        newTask.setExpirationDate(oldTask.getExpirationDate());
        newTask.setDescription(oldTask.getDescription());
        newTask.setStatus(oldTask.getStatus());

        taskDao.update(newTask);
    }


    public void createTask(String name, String username, String project,
                           int priority, Date deadline, String description) {

        logger.info(username + " Creating Task " + name);

        long millis = System.currentTimeMillis();
        java.sql.Date creationDate = new java.sql.Date(millis);

        Task task = new Task(name, username, projectDao.getByName(project).getId(), priority,
                creationDate, deadline, description, "created");

        TaskDao taskDao = new TaskDao();
        taskDao.add(task);
    }


    public List<Task> displayTasks(User user) throws Exception {
        try {
            List<Project> projects = projectDao.getAllByUser(user);
            for (Project project : projects) {
                if (project.getName().equals("Tasks of " + user.getUsername())) {
                    List<Task> tasks = taskDao.getAllByProject(project.getId());
                    Collections.reverse(tasks);
                    return tasks;
                }
            }
        } catch (Exception e) {
            logger.error("Cannot display tasks", e);
        }
        return new ArrayList<Task>();
    }

    public void deleteTask(int taskId) {
        taskDao.removeById(taskId);
    }


    public Task getByName(String taskName) {
        return taskDao.getByName(taskName);
    }

    public static final String CREATED = "created";
    public static final String IN_PROGRESS = "in progress";
    public static final String COMPLETED = "completed";

    public void changeStatus(Task task) {
        if (task.getStatus().equals(CREATED)) {
            task.setStatus(IN_PROGRESS);
            updateTask(task);
        } else if (task.getStatus().equals(IN_PROGRESS)) {
            task.setStatus(COMPLETED);
            updateTask(task);
        } else {
            logger.info("CANNOT CHANGE STATUS");
        }
    }
}
