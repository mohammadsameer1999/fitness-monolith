package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;
import com.project.fitness.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {
    private long userId;
    private ActivityType type;
    private Integer duration;
    private Map<String, Object> additionalMetrics;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
}

