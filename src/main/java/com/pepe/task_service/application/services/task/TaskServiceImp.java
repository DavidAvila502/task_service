package com.pepe.task_service.application.services.task;
import com.pepe.task_service.domain.models.Task;
import com.pepe.task_service.domain.ports.TaskRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService{
    private  final TaskRepository _taskRepository;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository){
        _taskRepository = taskRepository;
    }


    @Override
    public List<Task> findAll() {
        return _taskRepository.findAll();
    }

    @Override
    public Task save(Long userId,Task task) {

      task.validate();

      task.setUserId(userId);

        return _taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return _taskRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        _taskRepository.deleteById(id);
    }
}
