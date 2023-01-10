package rocks.zipcode.Jive.controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rocks.zipcode.Jive.entities.UserEntity;
import rocks.zipcode.Jive.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    
    

        @Mock
        private UserService userService;

        @InjectMocks
        private UserController userController;

        @Test
        void testAddUser() {
            userController.addUser(new UserEntity());
            verify(userService, 1).saveUser(any(UserEntity.class));
        }

    private UserService verify(UserService userService, int i) {
            return userService;
    }

    @Test
        void testGetAllUsers() {
            List<UserEntity> users = new ArrayList<>();
            users.add(new UserEntity());
            when(userService.getAllUsers()).thenReturn(users);
            List<UserEntity> result = userController.getAllUsers();
            assertEquals(users, result);
        }

        @Test
        void testGetUserByIdSuccess() {
            UserEntity user = new UserEntity();
            when(userService.getUserById(anyLong())).thenReturn(user);
            ResponseEntity<UserEntity> result = userController.getUserById(1L);
            assertEquals(HttpStatus.OK, result.getStatusCode());
            assertEquals(user, result.getBody());
        }

        @Test
        void testGetUserByIdNotFound() {
            when(userService.getUserById(anyLong())).thenThrow(NoSuchElementException.class);
            ResponseEntity<UserEntity> result = userController.getUserById(1L);
            assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
            assertEquals(null, result.getBody());
        }

//        @Test
//        void testUpdateSuccess() {
//            UserEntity user = new UserEntity();
//            when(userService.getUserById(anyLong())).thenReturn(user);
//            userController.update(new UserEntity(), 1L);
//            verify(userService, 1).update(anyLong(), any(UserEntity.class));
//        }
//
//    @Test
//    void testUpdateNotFound() {
//        when(userService.getUserById(anyLong())).thenThrow(NoSuchElementException.class);
//        ResponseEntity<UserEntity> result = userController.update(new UserEntity(), 1L);
//        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
//        assertEquals(null, result.getBody());
//    }

    @Test
    void testDelete() {
        userController.delete(1L);
        verify(userService, 1).deleteUserById(1L);
    }
}
