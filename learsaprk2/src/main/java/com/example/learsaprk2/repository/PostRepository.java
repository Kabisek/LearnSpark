package com.example.learsaprk2.repository;

import java.util.List;

import com.example.learsaprk2.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByUserId(String userId);

    List<Post> findByUserIdInOrderByCreatedAtDesc(List<String> userIds);
}