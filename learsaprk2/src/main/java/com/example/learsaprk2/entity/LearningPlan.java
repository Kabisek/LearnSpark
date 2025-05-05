package com.example.learsaprk2.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "learning_plans")
public class LearningPlan {

    @Id
    private String id;
    private String title;
    private List<String> topics;
    private List<String> resources;
    private LocalDate targetDate;
    private String progress;
    private String userId;

    public LearningPlan() {
    }

    public LearningPlan(String id, String title, List<String> topics, List<String> resources, LocalDate targetDate, String progress, String userId) {
        this.id = id;
        this.title = title;
        this.topics = topics;
        this.resources = resources;
        this.targetDate = targetDate;
        this.progress = progress;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}