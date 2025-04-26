package main.java.com.example.postmanagement.service;

import com.example.postmanagement.entity.Post;
import com.example.postmanagement.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return repository.save(post);
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Post getPostById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }

    public Post updatePost(String id, Post updatedPost) {
        Post existingPost = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setPath(updatedPost.getPath());
        existingPost.setUpdatedAt(LocalDateTime.now());
        return repository.save(existingPost);
    }

    public void deletePost(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Post not found with id: " + id);
        }
        repository.deleteById(id);
    }
}