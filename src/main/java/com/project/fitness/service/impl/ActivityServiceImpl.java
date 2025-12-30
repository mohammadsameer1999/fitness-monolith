package com.project.fitness.service.impl;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.mapper.ActivityMapper;
import com.project.fitness.model.Activity;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.service.ActivityService;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    private final ActivityMapper activityMapper;
    @Override
    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        System.out.println("service class called is here-----<><><><>" + activityRequest);

        // Use MapStruct to convert DTO to Entity
        Activity activity = activityMapper.requestToEntity(activityRequest);

        // Validate user exists
        userRepository.findById(activityRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found: " + activityRequest.getUserId()));

        Activity savedActivity = activityRepository.save(activity);
        System.out.println("save in db-----<><><><>" + savedActivity);

        // Use MapStruct to convert Entity to Response DTO
        return activityMapper.entityToResponse(savedActivity);
    }

    @Override
    public void deleteActivities(List<Long> ids) {
        activityRepository.deleteAllById(ids);
    }

    @Override
    public  List<Activity> getActivities() {
        return activityRepository.findAll();
    }


}
