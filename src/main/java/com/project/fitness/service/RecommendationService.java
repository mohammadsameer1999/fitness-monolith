package com.project.fitness.service;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;

public interface RecommendationService {
   public  Recommendation generateRecommendation(RecommendationRequest request);
}
