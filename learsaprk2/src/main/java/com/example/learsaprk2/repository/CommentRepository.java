package com.example.learsaprk2.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.learsaprk2.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}