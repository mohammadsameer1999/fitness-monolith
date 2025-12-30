package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ActivityService {
    public ActivityResponse trackActivity(ActivityRequest activityRequest);


    void deleteActivities(List<Long> ids);

     List<Activity> getActivities();
}
