package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;

import java.util.List;

public interface UserService {
    UserResponse register(RegisterRequest request);

    List<User> getUsers();

    void deleted(Long userId);
}
