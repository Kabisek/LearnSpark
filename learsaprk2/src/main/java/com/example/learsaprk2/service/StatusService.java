package com.example.learsaprk2.service;

import com.example.learsaprk2.entity.LearningStatus;
import com.example.learsaprk2.repository.StatuslearRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatusService {

    private final StatuslearRepository repository;

    public StatusService(StatuslearRepository repository) {
        this.repository = repository;
    }

    public LearningStatus createStatus(LearningStatus status) {
        status.setCreatedAt(LocalDateTime.now());
        if (status.getExpiresAt() == null) {
            status.setExpiresAt(LocalDateTime.now().plusHours(24)); // Default 24-hour expiry
        }
        return repository.save(status);
    }

    public List<LearningStatus> getAllActiveStatuses() {
        return repository.findByExpiresAtAfter(LocalDateTime.now());
    }

    public LearningStatus getStatusById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found with id: " + id));
    }

    public List<LearningStatus> getStatusesByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public LearningStatus updateStatus(String id, LearningStatus updatedStatus) {
        LearningStatus existingStatus = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found with id: " + id));
        existingStatus.setImagePath(updatedStatus.getImagePath());
        existingStatus.setCaption(updatedStatus.getCaption());
        existingStatus.setExpiresAt(updatedStatus.getExpiresAt());
        existingStatus.setUserId(updatedStatus.getUserId());
        return repository.save(existingStatus);
    }

    public void deleteStatus(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Status not found with id: " + id);
        }
        repository.deleteById(id);
    }
}