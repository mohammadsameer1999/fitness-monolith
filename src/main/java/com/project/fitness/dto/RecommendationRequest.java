package com.project.fitness.dto;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationRequest {
    private Long userId;
    private Long activityId;
    private String type;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
}
