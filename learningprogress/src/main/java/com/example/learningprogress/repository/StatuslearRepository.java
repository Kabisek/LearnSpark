package com.example.learningprogress.repository;

import com.example.learningprogress.entity.LearningStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface StatuslearRepository extends MongoRepository<LearningStatus, String> {
    List<LearningStatus> findByUserId(String userId);

    List<LearningStatus> findByExpiresAtAfter(LocalDateTime now);
}