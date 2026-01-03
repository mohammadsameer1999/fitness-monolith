package com.project.fitness.service.impl;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.service.RecommendationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    @Override
    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user  = userRepository.findById(request.getUserId())
                .orElseThrow(
                        () -> new RuntimeException("user not found with userId: " + request.getUserId())
                );
        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(
                        () -> new RuntimeException("Activtiy not found with id: " + request.getActivityId())
                );
        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .type(request.getType())
                .recommendation(request.getRecommendation())
                .improvements(request.getImprovements())
                .safety(request.getSafety())
                .suggestions(request.getSuggestions())
                .build();
        return recommendationRepository.save(recommendation);
    }
}
