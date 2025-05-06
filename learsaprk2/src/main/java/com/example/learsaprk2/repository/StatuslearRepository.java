package com.example.learsaprk2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.learsaprk2.entity.LearningStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface StatuslearRepository extends MongoRepository<LearningStatus, String> {
    List<LearningStatus> findByUserId(String userId);

    List<LearningStatus> findByExpiresAtAfter(LocalDateTime now);
}