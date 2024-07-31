package dev.reis.todo.list.domain.task.usecase;

import org.springframework.stereotype.Service;

import dev.reis.todo.list.domain.task.dto.SaveTaskRequestDTO;
import dev.reis.todo.list.infra.database.entity.Task;
import dev.reis.todo.list.infra.database.repository.TaskRepository;
@Service
public class SaveTaskUseCase {
    private TaskRepository taskRepository;
    public SaveTaskUseCase(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task execute(SaveTaskRequestDTO body){

        Task task = new Task();
        task.setTitle(body.title());
        task.setContent(body.content());
        task.setStatus("pending");
        var taskDB = taskRepository.save(task);

        return taskDB;
    }
}
