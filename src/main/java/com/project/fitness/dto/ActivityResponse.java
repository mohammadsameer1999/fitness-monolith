package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponse {
    private Long id;

    private long userId;


    private ActivityType type;

    private Integer duration;
    private Map<String, Object> additionalMetrics;

    private Integer caloriesBurned;

    private LocalDateTime startTime;


    private List<Recommendation> recommendations = new ArrayList<>();

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
