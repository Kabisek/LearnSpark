package com.example.learsaprk2.controller;

import com.example.learsaprk2.entity.LearningStatus;
import com.example.learsaprk2.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class LearningStatusController {

    @Autowired
    private StatusService service;

    @PostMapping
    public LearningStatus createStatus(@RequestBody LearningStatus status) {
        return service.createStatus(status);
    }

    @GetMapping
    public List<LearningStatus> getAllActiveStatuses() {
        return service.getAllActiveStatuses();
    }

    @GetMapping("/{id}")
    public LearningStatus getStatusById(@PathVariable String id) {
        return service.getStatusById(id);
    }

    @GetMapping("/user/{userId}")
    public List<LearningStatus> getStatusesByUserId(@PathVariable String userId) {
        return service.getStatusesByUserId(userId);
    }

    @PutMapping("/{id}")
    public LearningStatus updateStatus(@PathVariable String id, @RequestBody LearningStatus status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable String id) {
        service.deleteStatus(id);
    }
}