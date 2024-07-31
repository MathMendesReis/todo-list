package dev.reis.todo.list.infra.database.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.reis.todo.list.infra.database.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>{
    
}
