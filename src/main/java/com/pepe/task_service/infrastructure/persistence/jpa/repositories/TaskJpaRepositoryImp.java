package com.pepe.task_service.infrastructure.persistence.jpa.repositories;

import com.pepe.task_service.domain.models.Task;
import com.pepe.task_service.domain.ports.TaskRepository;
import com.pepe.task_service.infrastructure.persistence.jpa.entities.TaskJpaEntity;
import com.pepe.task_service.infrastructure.persistence.mapper.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskJpaRepositoryImp implements TaskRepository {

    private final TaskJpaRepository jpaRepository;
    private final TaskMapper mapper;

    public TaskJpaRepositoryImp(TaskJpaRepository jpaRepository, TaskMapper mapper){
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Task save(Task task) {
        TaskJpaEntity jpaEntity = mapper.toJpaEntity(task);
        TaskJpaEntity savedEntity = jpaRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);

    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
       List<TaskJpaEntity> taskEntitiesList = jpaRepository.findAll();
       return taskEntitiesList.stream().map(mapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {

    }
}
