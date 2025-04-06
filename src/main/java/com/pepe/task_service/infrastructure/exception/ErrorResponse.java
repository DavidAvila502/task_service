package com.pepe.task_service.infrastructure.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Map<String, String> details; // For field-specific errors

    public ErrorResponse(LocalDateTime timestamp, int status, String message, Map<String, String> details) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }

}