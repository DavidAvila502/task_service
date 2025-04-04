package com.pepe.task_service.infrastructure.persistence.jpa.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Task")
public class TaskJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    @NotNull(message = "Due date is required")
    @Future(message = "Due date must be in the future")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") // ISO 8601
    @Column(name = "due_date",nullable = false)
    private LocalDateTime dueDate;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    public TaskJpaEntity(){}

    public TaskJpaEntity(Long id,String title, String description, LocalDateTime dueDate, Long userId){
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.userId = userId;
    }
}
