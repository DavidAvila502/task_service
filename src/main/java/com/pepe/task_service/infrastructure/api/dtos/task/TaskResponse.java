package com.pepe.task_service.infrastructure.api.dtos.task;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private String status;

    public TaskResponse(String title, String description, LocalDateTime dueDate, Long id, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.id = id;
        this.status = status;
    }
}
