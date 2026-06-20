package com.cognizant;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepository;
import com.cognizant.service.UserService;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testGetUserById() {

        UserRepository mockRepository =
                mock(UserRepository.class);

        User user = new User();
        user.setId(1L);
        user.setName("Sai");

        when(mockRepository.findById(1L))
                .thenReturn(Optional.of(user));

        UserService service =
                new UserService(mockRepository);

        User result =
                service.getUserById(1L);

        assertNotNull(result);

        assertEquals(
                "Sai",
                result.getName()
        );

        verify(mockRepository)
                .findById(1L);
    }
}