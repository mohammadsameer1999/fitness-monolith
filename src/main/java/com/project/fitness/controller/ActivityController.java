package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getActivities")
    public ResponseEntity<List<Activity>> getAllActivities() {
        return ResponseEntity.ok(activityService.getActivities());
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader(value = "X-User-ID") Long userId ) {
        return ResponseEntity.ok(activityService.getUserActivites(userId));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteActivities(@RequestParam List<Long> ids) {
        activityService.deleteActivities(ids);
        return ResponseEntity.noContent().build();
    }

}
