package com.project.fitness.mapper;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    @Mapping(source = "userId", target = "user", qualifiedByName = "mapUserIdToUser")
    Activity requestToEntity(ActivityRequest request);

    @Mapping(source = "user.id", target = "userId")
    ActivityResponse entityToResponse(Activity activity);

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }
}