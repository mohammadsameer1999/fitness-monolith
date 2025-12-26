package com.project.fitness.service.impl;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    @Override
    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        System.out.println("service class called is here-----<><><><>" + activityRequest);
        Activity activity  = Activity.builder()
                        .user(userRepository.findById(activityRequest.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not found" + activityRequest.getUserId())))
//                        .types(activityRequest.getTypes())
                        .additionalMetrics(activityRequest.getAdditionalMetrics())
                        .duration(activityRequest.getDuration())
                        .caloriesBurned(activityRequest.getCaloriesBurned())
                        .startTime(activityRequest.getStartTime())
                        .build();
        Activity savedActivity = activityRepository.save(activity);
        System.out.println("save in db-----<><><><>" + savedActivity);

        return mapTOResponse(savedActivity);
    }

    private ActivityResponse mapTOResponse(Activity savedActivity) {
        return ActivityResponse.builder()
                .id(savedActivity.getId())
                .userId(savedActivity.getUser().getId())
//                .types(savedActivity.getTypes())
                .additionalMetrics(savedActivity.getAdditionalMetrics())
                .duration(savedActivity.getDuration())
                .caloriesBurned(savedActivity.getCaloriesBurned())
                .startTime(savedActivity.getStartTime())
                .build();
    }
}
