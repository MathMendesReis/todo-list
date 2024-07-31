package dev.reis.todo.list.infra.htpp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.reis.todo.list.domain.task.usecase.ListTaskUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("task")
public class ListAllTasksController {
    @Autowired 
    private ListTaskUseCase useCase;
    
    @GetMapping()
    public ResponseEntity<?> handle() {
        var response = useCase.execute();
        try {
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
