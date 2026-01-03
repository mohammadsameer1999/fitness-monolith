package com.project.fitness.mapper;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User requestToEntity(RegisterRequest request);

    UserResponse entityToResponse(User user);
}