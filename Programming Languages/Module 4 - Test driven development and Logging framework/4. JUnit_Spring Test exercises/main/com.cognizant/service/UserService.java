package com.cognizant.service;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {

        return userRepository
                .findById(id)
                .orElse(null);
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }
}