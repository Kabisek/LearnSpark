package com.example.learsaprk2.repository;

import com.example.learsaprk2.entity.LearningPlan;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LearningPlanRepository extends MongoRepository<LearningPlan, String> {
    List<LearningPlan> findByUserId(String userId);
}