package com.example.learsaprk2.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.learsaprk2.entity.Follow;
import com.example.learsaprk2.entity.FollowStatus;


public interface FollowRepository extends MongoRepository<Follow, String> {

    List<Follow> findByFollowerId(String userId);

    boolean existsByFollowerIdAndFollowingId(String followerId, String followingId);

    List<Follow> findByFollowingIdAndStatus(String userId, FollowStatus status);

    List<Follow> findByFollowerIdAndStatus(String userId, FollowStatus status);

    Optional<Follow> findByFollowerIdAndFollowingId(String followerId, String followingId);
}
