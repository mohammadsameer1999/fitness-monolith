package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/trackActivity")
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest activityRequest) {
        System.out.println("req body is here----<><><><><><>" + activityRequest);
        return ResponseEntity.ok(activityService.trackActivity(activityRequest));
    }

}
