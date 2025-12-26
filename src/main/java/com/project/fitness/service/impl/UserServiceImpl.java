package com.project.fitness.service.impl;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse register(RegisterRequest request) {

        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User savedUser) {

        return UserResponse.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .build();
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("find All User list is here ----> " + users);
        return users;
    }

    @Override
    public void deleted(Long userId) {
        userRepository.deleteById(userId);
    }
}
