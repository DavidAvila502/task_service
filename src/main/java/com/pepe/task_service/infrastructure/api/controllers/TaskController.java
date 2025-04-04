package com.pepe.task_service.infrastructure.api.controllers;

import com.pepe.task_service.application.services.task.TaskService;
import com.pepe.task_service.domain.models.Task;
import com.pepe.task_service.infrastructure.api.dtos.task.TaskRequest;
import com.pepe.task_service.infrastructure.api.dtos.task.TaskResponse;
import com.pepe.task_service.infrastructure.persistence.mapper.TaskMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService _taskService;
    private final TaskMapper _taskMapper;

    @Autowired
    public TaskController(TaskService taskService,TaskMapper taskMapper){
        this._taskService = taskService;
        this._taskMapper = taskMapper;

    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks(){

        List<Task> tasks = _taskService.findAll();
        List<TaskResponse> taskResponses = tasks.stream().map(_taskMapper::toTaskResponse).toList();
        return ResponseEntity.ok().body(taskResponses);
    }

    @PostMapping("/{userId}")
    public  ResponseEntity<TaskResponse> createTask(@PathVariable Long userId,@Valid @RequestBody TaskRequest taskRequest){

        Task task = _taskMapper.toDomain(taskRequest);

        Task taskCreated = _taskService.save(userId,task);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{Id}")
                .buildAndExpand(taskCreated.getId())
                .toUri();

        TaskResponse taskResponse = _taskMapper.toTaskResponse(taskCreated);

        return ResponseEntity.created(location).body(taskResponse);
    }


}
