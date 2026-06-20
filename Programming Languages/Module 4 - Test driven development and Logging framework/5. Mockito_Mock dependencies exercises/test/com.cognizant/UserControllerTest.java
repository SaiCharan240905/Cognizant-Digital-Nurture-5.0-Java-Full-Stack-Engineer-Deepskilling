package com.cognizant;

import com.cognizant.controller.UserController;
import com.cognizant.entity.User;
import com.cognizant.service.UserService;

import org.junit.jupiter.api.Test;

import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Test
    void testGetUser() {

        UserService mockUserService =
                mock(UserService.class);

        User user = new User();
        user.setId(1L);
        user.setName("Sai");

        when(mockUserService.getUserById(1L))
                .thenReturn(user);

        UserController controller =
                new UserController(mockUserService);

        ResponseEntity<User> response =
                controller.getUser(1L);

        assertEquals(
                "Sai",
                response.getBody().getName()
        );

        verify(mockUserService)
                .getUserById(1L);
    }
}