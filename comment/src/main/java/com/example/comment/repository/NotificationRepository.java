package com.example.comment.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.comment.entity.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findByUserIdOrderByTimestampDesc(String userId);
}

