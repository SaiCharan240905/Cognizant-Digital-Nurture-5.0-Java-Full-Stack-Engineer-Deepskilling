package com.cognizant;

import com.cognizant.controller.UserController;
import com.cognizant.entity.User;
import com.cognizant.service.UserService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    @Test
    void testGetUser() throws Exception {

        UserService userService =
                Mockito.mock(UserService.class);

        User user = new User();
        user.setId(1L);
        user.setName("Sai");

        Mockito.when(
                userService.getUserById(1L)
        ).thenReturn(user);

        UserController controller =
                new UserController(userService);

        MockMvc mockMvc =
                MockMvcBuilders
                        .standaloneSetup(controller)
                        .build();

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk());
    }
}