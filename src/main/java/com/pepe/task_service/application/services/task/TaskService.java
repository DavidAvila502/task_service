package com.pepe.task_service.application.services.task;
import com.pepe.task_service.domain.models.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();
    Task save(Long userId,Task task);
    Optional<Task> findById(Long id);
    void deleteById(Long id);
}
