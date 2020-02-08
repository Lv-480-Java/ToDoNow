package andriypyzh.services;


import andriypyzh.dao.Implementation.ProjectDao;
import andriypyzh.dao.Implementation.TaskDao;
import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;
import org.apache.log4j.Logger;

import javax.persistence.criteria.Predicate;
import javax.sound.midi.MidiFileFormat;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class ProjectService {
    Logger logger = Logger.getLogger(ProjectService.class);

    public Project getUsersProject(User user, String projectName) throws Exception {
        ProjectDao projectDao = new ProjectDao();

        List<Project> projects = projectDao.getAllByUser(user);

        Project project = projects.stream()
                .filter((x) -> x.getName().equals(projectName))
                .findAny()
                .orElse(null);
        if (project == null) {
            logger.error("No such Project");
            throw new Exception("No such project");
        }

        return project;
    }

    public List<Task> getProjectTasks(User user, String projectName) throws Exception {
        TaskDao taskDao = new TaskDao();

        Project project = getUsersProject(user, projectName);

        return taskDao.getAllByProject(project.getId());
    }


}
