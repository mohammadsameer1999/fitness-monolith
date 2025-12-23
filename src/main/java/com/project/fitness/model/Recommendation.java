package com.project.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recommendations")
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many recommendations belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_recommendation_user")
    )
    @JsonIgnore
    private User user;

    // Many recommendations belong to one activity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "activity_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_recommendation_activity")
    )
    @JsonIgnore
    private Activity activity;

    @NotBlank
    @Column(nullable = false)
    private String type;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String recommendation;

    @ElementCollection
    @CollectionTable(
            name = "recommendation_improvements",
            joinColumns = @JoinColumn(name = "recommendation_id")
    )
    @Column(name = "improvement", nullable = false)
    @NotEmpty
    private List<String> improvements;

    @ElementCollection
    @CollectionTable(
            name = "recommendation_suggestions",
            joinColumns = @JoinColumn(name = "recommendation_id")
    )
    @Column(name = "suggestion", nullable = false)
    @NotEmpty
    private List<String> suggestions;

    @ElementCollection
    @CollectionTable(
            name = "recommendation_safety",
            joinColumns = @JoinColumn(name = "recommendation_id")
    )
    @Column(name = "safety_item", nullable = false)
    @NotEmpty
    private List<String> safety;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

