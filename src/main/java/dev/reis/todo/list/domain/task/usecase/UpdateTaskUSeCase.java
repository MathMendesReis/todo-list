package dev.reis.todo.list.domain.task.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.reis.todo.list.domain.task.dto.UpdateTaskDTO;
import dev.reis.todo.list.infra.database.entity.Task;
import dev.reis.todo.list.infra.database.repository.TaskRepository;

@Service
public class UpdateTaskUSeCase {

    private final TaskRepository taskRepository;

    public UpdateTaskUSeCase(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void execute(String postId, UpdateTaskDTO body) {
        var taskDB = taskRepository.findById(UUID.fromString(postId)).orElseThrow(()->new RuntimeException("Task not found"));

        if(!body.getContent().isEmpty() && body.getContent() != null){
            taskDB.setTitle(body.getContent());
        }
        if(!body.getTitle().isEmpty() && body.getTitle() != null){
            taskDB.setContent(body.getTitle());
        }

        taskRepository.save(taskDB);
    }
}
