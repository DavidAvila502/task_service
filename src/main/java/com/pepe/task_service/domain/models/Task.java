package com.pepe.task_service.domain.models;

import jakarta.validation.ValidationException;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Long userId;

    public Task(){}
    public Task(
            Long id,
            String title,
            String description,
            LocalDateTime dueDate,
            Long userId
    ){
        this.id = id;
        this.title = title;
        this.description =description;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    public void validate(){
        if(dueDate == null){
            throw new ValidationException("Due date is required");
        }
        if(dueDate.isBefore(LocalDateTime.now())){
            throw new ValidationException("Due date must be in the future");
        }
        if(title == null || title.isBlank()){
            throw new ValidationException("Title is required");
        }

    }

    //Getters
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public Long getUserId() {
        return userId;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

