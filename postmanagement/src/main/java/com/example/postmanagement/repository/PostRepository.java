package main.java.com.example.postmanagement.repository;

import com.example.postmanagement.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}