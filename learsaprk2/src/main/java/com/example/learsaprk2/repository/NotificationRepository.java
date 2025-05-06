package com.example.learsaprk2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.learsaprk2.entity.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findByUserIdOrderByTimestampDesc(String userId);
}
