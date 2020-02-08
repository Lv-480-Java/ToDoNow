package andriypyzh.dao.Implementation;

import andriypyzh.entity.Project;
import org.junit.jupiter.api.Test;

import java.sql.Date;

class ProjectDaoTest {



    @Test
    void test1() {
        ProjectDao projectImpl = new ProjectDao();
        UserDao userDao = new UserDao();

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


//        System.out.println(projectImpl.getAllByUser(userImpl.getByName("andriy")));


        projectImpl.removeById(0);
        projectImpl.removeById(1);
        projectImpl.removeById(2);
    }
}