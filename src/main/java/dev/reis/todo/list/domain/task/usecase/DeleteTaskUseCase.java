package dev.reis.todo.list.domain.task.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.reis.todo.list.infra.database.repository.TaskRepository;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository taskRepository;

    public DeleteTaskUseCase(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void execute(String postId) {
        var taskDB = taskRepository.findById(UUID.fromString(postId)).orElseThrow(()->new RuntimeException("Task not found"));
        taskRepository.deleteById(taskDB.getId());;
    }
}
