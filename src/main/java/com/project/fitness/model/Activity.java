package com.project.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many activities belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_activity_user")
    )
    @JsonIgnore
    private User user;   // ✅ FIXED

    private ActivityType type;

    private Integer duration;

    private Integer caloriesBurned;

    private LocalDateTime startTime;

    // JSON column
    @JdbcTypeCode(SqlTypes.JSON)

    @Column(columnDefinition = "json")
    private Map<String, Object> additionalMetrics;

    // One activity → many recommendations
    @OneToMany(
            mappedBy = "activity",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Recommendation> recommendations = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
