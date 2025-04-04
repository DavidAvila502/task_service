package com.pepe.task_service.infrastructure.persistence.mapper;

import com.pepe.task_service.domain.models.Task;
import com.pepe.task_service.infrastructure.api.dtos.task.TaskRequest;
import com.pepe.task_service.infrastructure.api.dtos.task.TaskResponse;
import com.pepe.task_service.infrastructure.persistence.jpa.entities.TaskJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskJpaEntity toJpaEntity(Task domainTask) {
        return new TaskJpaEntity(
                domainTask.getId(),
                domainTask.getTitle(),
                domainTask.getDescription(),
                domainTask.getDueDate(),
                domainTask.getUserId()
        );
    }

    public Task toDomain(TaskJpaEntity jpaEntity) {
        return new Task(
                jpaEntity.getId(),
                jpaEntity.getTitle(),
                jpaEntity.getDescription(),
                jpaEntity.getDueDate(),
                jpaEntity.getUserId()
        );
    }

    public Task toDomain(TaskRequest taskRequest){
        Task task =  new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());

        return  task;
    }

    public TaskResponse toTaskResponse(Task task){
        return new TaskResponse(
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getId(),
                task.isOverDue() ? "OVERDUE" : "PENDING"
                );
    }


}
