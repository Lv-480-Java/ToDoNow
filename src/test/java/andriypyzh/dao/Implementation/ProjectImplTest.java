package andriypyzh.dao.Implementation;

import andriypyzh.entity.Project;
import andriypyzh.entity.User;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProjectImplTest {



    @Test
    void test1() {
        ProjectImpl projectImpl = new ProjectImpl();
        UserImpl userImpl = new UserImpl();

        Project project1 = new Project(0, "project1", "ilon",
                new Date(1000L), new Date(1000L), "hello world", "Created", "default");
        Project project2 = new Project(1, "project2", "andriy",
                new Date(1000L), new Date(1000L), "hello world", "Created", "default");
        Project project3 = new Project(2, "project3", "andriy",
                new Date(1000L), new Date(1000L), "hello world", "Created", "default");

        projectImpl.add(project1);
        projectImpl.add(project2);
        projectImpl.add(project3);

        System.out.println(projectImpl.getById(0));
        System.out.println(projectImpl.getById(1));
        System.out.println(projectImpl.getById(2));

        System.out.println(projectImpl.getByName("project1"));
        System.out.println(projectImpl.getByName("project2"));
        System.out.println(projectImpl.getByName("project3"));


        System.out.println(projectImpl.getAllByUser(userImpl.getByName("andriy")));

//
//        projectImpl.remove(0);
//        projectImpl.remove(1);
//        projectImpl.remove(2);
    }
}