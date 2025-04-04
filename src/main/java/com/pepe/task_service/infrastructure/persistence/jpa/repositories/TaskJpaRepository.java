package com.pepe.task_service.infrastructure.persistence.jpa.repositories;
import com.pepe.task_service.infrastructure.persistence.jpa.entities.TaskJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<TaskJpaEntity,Long> {
}
