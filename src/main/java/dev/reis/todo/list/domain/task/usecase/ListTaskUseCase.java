package dev.reis.todo.list.domain.task.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.reis.todo.list.infra.database.entity.Task;
import dev.reis.todo.list.infra.database.repository.TaskRepository;

@Service
public class ListTaskUseCase {

    private final TaskRepository taskRepository;

    public ListTaskUseCase(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> execute(){
        var listTask = taskRepository.findAll();
        return listTask;
    }
}
