package andriypyzh.services;

import andriypyzh.dao.Implementation.ProjectImpl;
import andriypyzh.dao.Implementation.TaskImpl;
import andriypyzh.entity.Project;
import andriypyzh.entity.Task;
import andriypyzh.entity.User;

import java.lang.ref.PhantomReference;
import java.util.List;

public class TaskService {

    public  List<Task> displayTasks(User user) throws Exception {
        TaskImpl taskDao = new TaskImpl();
        ProjectImpl projectDao = new ProjectImpl();

        List<Project> projects = projectDao.getAllByUser(user);
        for (Project project:projects){
            System.out.println(project.getType());
            if (project.getType().equals("default")){
                return taskDao.getAllByProject(project.getId());
            }
        }
        throw new Exception();
    }

}
