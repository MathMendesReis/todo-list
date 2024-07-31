package dev.reis.todo.list.domain.task.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.reis.todo.list.domain.task.dto.UpdateStatusDTO;
import dev.reis.todo.list.infra.database.repository.TaskRepository;

@Service
public class UpdateStatusTaskUSeCase {
    private TaskRepository taskRepository;

    public UpdateStatusTaskUSeCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void execute(String postId,UpdateStatusDTO body)  {
        var taskDB = taskRepository.findById(UUID.fromString(postId))
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!body.status().isEmpty() && body.status() != null) {
            taskDB.setStatus(body.status());
        }
       

        taskRepository.save(taskDB);
    }
}
