//package rocks.zipcode.Jive.services;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import rocks.zipcode.Jive.entities.UserEntity;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserServiceTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Before
//    public void setUp() {
//        userService.deleteAllUsers();
//    }
//
//    @After
//    public void tearDown() {
//        userService.deleteAllUsers();
//    }
//
//
//    @Test
//    public void testGetAllUsers() {
//        UserEntity user1 = new UserEntity("John", "password1");
//        UserEntity user2 = new UserEntity("Jane", "password2");
//        userService.saveUser(user1);
//        userService.saveUser(user2);
//        List<UserEntity> expectedUsers = Arrays.asList(user1, user2);
//        List<UserEntity> actualUsers = userService.getAllUsers();
//        assertEquals(expectedUsers, actualUsers);
//    }
//
//    @Test
//    public void testGetUserById() {
//        UserEntity user = new UserEntity("John", "password1");
//        userService.saveUser(user);
//        Long id = user.getId();
//        UserEntity expectedUser = user;
//        UserEntity actualUser = userService.getUserById(id);
//        assertEquals(expectedUser, actualUser);
//    }
//
//    @Test
//    public void testSaveUser() {
//        UserEntity user = new UserEntity("John", "password1");
//        userService.saveUser(user);
//        UserEntity expectedUser = user;
//        UserEntity actualUser = userService.getUserById(user.getId());
//        assertEquals(expectedUser, actualUser);
//    }
//
//    @Test
//    public void testDeleteUserById() {
//        UserEntity user = new UserEntity("John", "password1");
//        userService.saveUser(user);
//        Long id = user.getId();
//        userService.deleteUserById(id);
//        assertFalse(userService.getAllUsers().contains(user));
//    }
//}
