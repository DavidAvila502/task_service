package com.pepe.task_service.infrastructure.api.dtos.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
@Data
public class TaskRequest {
    @NotBlank(message = "Title is required")
    @Length(max = 200)
    private String title;
    @Length(max = 500)
    private String description;
    @Future(message = "Due date must be in the future")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") // ISO 8601
    @NotNull
    private LocalDateTime dueDate;

}
