package dev.reis.todo.list.infra.htpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.reis.todo.list.domain.task.usecase.DeleteTaskUseCase;

@RestController
@RequestMapping("task")
public class DeleteTaskByIdController {
    
    @Autowired
    private DeleteTaskUseCase deleteTaskUseCase;
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> handle(@PathVariable String postId) {
        deleteTaskUseCase.execute(postId);
        try {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
