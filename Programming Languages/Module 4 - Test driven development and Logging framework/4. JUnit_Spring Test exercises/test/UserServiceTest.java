package com.cognizant;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepository;
import com.cognizant.service.UserService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById() {

        userRepository =
                mock(UserRepository.class);

        userService =
                new UserService(userRepository);

        User user = new User();
        user.setId(1L);
        user.setName("Sai");

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        User result =
                userService.getUserById(1L);

        assertEquals(
                "Sai",
                result.getName()
        );
    }
}