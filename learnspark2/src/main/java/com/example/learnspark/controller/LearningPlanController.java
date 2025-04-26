package com.example.learnspark.controller;

import com.example.learnspark.entity.LearningPlan;
import com.example.learnspark.entity.LearningPlanResponse;
import com.example.learnspark.service.LearningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learning-plans")
public class LearningPlanController {

    @Autowired
    private LearningPlanService planService;

    @PostMapping
    public LearningPlan createPlan(@RequestBody LearningPlan plan) {
        return planService.save(plan);
    }

    @GetMapping("/user/{userId}")
    public List<LearningPlan> getPlansByUserId(@PathVariable String userId) {
        return planService.getPlansByUserId(userId);
    }

    @GetMapping
    public List<LearningPlanResponse> getAllPlans() {
        return planService.getAllPlans().stream()
                .map(LearningPlanResponse::new)
                .toList();
    }

    @GetMapping("/all")
    public List<LearningPlanResponse> getAllPlansLegacy() {
        return planService.getAllPlans().stream()
                .map(LearningPlanResponse::new)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable String id) {
        planService.deleteById(id);
    }
}