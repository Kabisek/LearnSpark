package com.example.learsaprk2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learsaprk2.entity.LearningPlan;
import com.example.learsaprk2.entity.LearningPlanResponse;
import com.example.learsaprk2.service.LearningPlanService;

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

      @GetMapping("/all")
      public List<LearningPlanResponse> getAllPlans() {
          return planService.getAllPlans().stream()
                  .map(LearningPlanResponse::new)
                  .toList();
      }

      @DeleteMapping("/{id}")
      public void deletePlan(@PathVariable String id) {
          planService.deleteById(id);
      }
  }