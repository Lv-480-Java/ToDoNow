package andriypyzh.dao.Implementation;

import andriypyzh.entity.User;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class UserImplTest {

    @org.junit.jupiter.api.Test
    void UserDaoTest() {
        UserImpl userService = new UserImpl();

        System.out.println(userService.getByName("Andriy"));

        User user1 = new User(1, "Ilon Mask", "1234");
        User user2 = new User(2, "Jeff Besos", "0000");
        User user3 = new User(3, "Bill Gates", "1111");

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);


//        Assert.assertEquals(new User());

        System.out.println(userService.getByName("Bill Gates"));

        userService.update(new User(3, "Bill Gates", "3333"));

        System.out.println(userService.getById(3));

        for (User u : userService.getAll()) {

        }
        userService.removeById(1);
        userService.removeById(2);
        userService.removeById(3);


    }
}