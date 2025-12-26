package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;

public interface ActivityService {
    public ActivityResponse trackActivity(ActivityRequest activityRequest);

}
