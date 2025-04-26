package com.example.learnspark.repository;

import com.example.learnspark.entity.LearningPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LearningPlanRepository extends MongoRepository<LearningPlan, String> {
    List<LearningPlan> findByUserId(String userId);
}