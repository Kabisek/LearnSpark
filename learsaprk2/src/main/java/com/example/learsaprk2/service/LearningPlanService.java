package com.example.learsaprk2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.learsaprk2.entity.LearningPlan;
import com.example.learsaprk2.repository.LearningPlanRepository;

@Service
public class LearningPlanService {

    private final LearningPlanRepository repository;

    public LearningPlanService(LearningPlanRepository repository) {
        this.repository = repository;
    }

    public LearningPlan save(LearningPlan learningPlan) {
        return repository.save(learningPlan);
    }

    public List<LearningPlan> getPlansByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<LearningPlan> getAllPlans() {
        return repository.findAll();
    }

    public LearningPlan getPlanById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("LearningPlan not found with id: " + id));
    }

    public void deleteById(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("LearningPlan not found with id: " + id);
        }
        repository.deleteById(id);
    }
}