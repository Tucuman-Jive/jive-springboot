//package rocks.zipcode.Jive.services;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import rocks.zipcode.Jive.entities.UserEntity;
//import rocks.zipcode.Jive.repositories.UserRepository;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserServiceTest {
//
//    private UserService userService;
//    private UserRepository userRepository;
////    UserEntity user1 = new UserEntity();
//
//
////    @Mock
////    private UserRepository userRepository;
//
////    private UserService userService;
//
//    private final UserEntity user1 = new UserEntity(1L, "user1", "password1");
//    private final UserEntity user2 = new UserEntity(2L, "user2", "password2");
//    private final UserEntity newUser = new UserEntity(3L, "user3", "password3");
//
//    @Before
//    public void setUp() {
//        userService = new UserService(userRepository);
//    }
//
//    @Test
//    public void getAllUsers_shouldReturnAllUsers() {
//        List<UserEntity> expectedUsers = Arrays.asList(user1, user2);
//        when(userRepository.findAll()).thenReturn(expectedUsers);
//
//        List<UserEntity> result = userService.getAllUsers();
//
//        verify(userRepository, times(1)).findAll();
//        assertThat(result).isEqualTo(expectedUsers);
//    }
//
//    @Test
//    public void getUserById_shouldReturnUser() {
//        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
//
//        UserEntity result = userService.getUserById(1L);
//
//        verify(userRepository, times(1)).findById(1L);
//        assertThat(result).isEqualTo(user1);
//    }
//
//    @Test
//    public void saveUser_shouldSaveUser() {
//        when(userRepository.save(newUser)).thenReturn(newUser);
//
//        userService.saveUser(newUser);
//
//        verify(userRepository, times(1)).save(newUser);
//    }
//
//    @Test
//    public void deleteUserById_shouldDeleteUser() {
//        userService.deleteUserById(1L);
//
//        verify(userRepository, times(1)).deleteById(1L);
//    }
//}
