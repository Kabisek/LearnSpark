package com.example.learsaprk2.service;


import com.example.learsaprk2.entity.Comment;
import com.example.learsaprk2.repository.CommentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public Comment createComment(Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        return repository.save(comment);
    }

    public List<Comment> getAllComments() {
        return repository.findAll();
    }

    public Comment getCommentById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
    }

    public Comment updateComment(String id, Comment updatedComment) {
        Comment existingComment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
        existingComment.setContent(updatedComment.getContent());
        existingComment.setPostId(updatedComment.getPostId());
        existingComment.setUserId(updatedComment.getUserId());
        return repository.save(existingComment);
    }

    public void deleteComment(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Comment not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
