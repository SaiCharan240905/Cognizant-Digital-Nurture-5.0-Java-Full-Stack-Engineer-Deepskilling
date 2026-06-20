package com.cognizant;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserIntegrationTest {

    @Autowired
    private UserRepository repository;

    @Test
    void testDatabaseFlow() {

        User user = new User();
        user.setName("Sai");

        repository.save(user);

        assertTrue(
                repository.findAll()
                        .size() > 0
        );
    }
}