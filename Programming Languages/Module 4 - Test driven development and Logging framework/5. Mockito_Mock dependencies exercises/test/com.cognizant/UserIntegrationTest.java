package com.cognizant;

import com.cognizant.entity.User;
import com.cognizant.service.UserService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetUserEndpoint() throws Exception {

        User user = new User();
        user.setId(1L);
        user.setName("Sai");

        when(userService.getUserById(1L))
                .thenReturn(user);

        mockMvc.perform(
                    get("/users/1")
                )
                .andExpect(status().isOk());

        verify(userService)
                .getUserById(1L);
    }
}