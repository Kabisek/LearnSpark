package com.example.learsaprk2.service;

import com.example.learsaprk2.entity.LearningPlan;

import com.example.learsaprk2.repository.LearningPlanRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LearningPlanService {

    @Autowired
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

    public LearningPlan updatePlan(String id, LearningPlan updatedPlan) {
        LearningPlan existingPlan = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("LearningPlan not found with id: " + id));
        existingPlan.setTitle(updatedPlan.getTitle());
        existingPlan.setTopics(updatedPlan.getTopics());
        existingPlan.setResources(updatedPlan.getResources());
        existingPlan.setTargetDate(updatedPlan.getTargetDate());
        existingPlan.setProgress(updatedPlan.getProgress());
        existingPlan.setUserId(updatedPlan.getUserId());
        return repository.save(existingPlan);
    }
}
