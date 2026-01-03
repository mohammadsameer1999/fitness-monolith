package com.project.fitness.service.impl;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.mapper.UserMapper;
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
    private final UserMapper userMapper;

    @Override
    public UserResponse register(RegisterRequest request) {

        User user = userMapper.requestToEntity(request);
        User savedUser = userRepository.save(user);

        return userMapper.entityToResponse(savedUser);
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
