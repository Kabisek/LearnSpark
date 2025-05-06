package com.example.learsaprk2.entity;

import java.time.LocalDate;
import java.util.List;

public class LearningPlanResponse {

    private String id;
    private String title;
    private List<String> topics;
    private List<String> resources;
    private LocalDate targetDate;
    private String progress;
    private String userId;

    public LearningPlanResponse() {
    }

    public LearningPlanResponse(LearningPlan plan) {
        this.id = plan.getId();
        this.title = plan.getTitle();
        this.topics = plan.getTopics();
        this.resources = plan.getResources();
        this.targetDate = plan.getTargetDate();
        this.progress = plan.getProgress();
        this.userId = plan.getUserId();
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