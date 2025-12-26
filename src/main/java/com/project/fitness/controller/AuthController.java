package com.project.fitness.controller;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok( userService.register(registerRequest));

    }

    @GetMapping("/getAllUser")

    public List<User> getAllUser() {
        return userService.getUsers();
    }

    @DeleteMapping("/{id}")

    public void deleteUser(@PathVariable("id") long userId) {
         userService.deleted(userId);
    }


}
