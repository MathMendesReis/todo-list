package dev.reis.todo.list.infra.htpp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.reis.todo.list.domain.task.dto.SaveTaskRequestDTO;
import dev.reis.todo.list.domain.task.usecase.SaveTaskUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("task")
public class SaveTaskController {

    @Autowired
    private SaveTaskUseCase saveTaskUseCase;

    @PostMapping()
    public ResponseEntity<?> handle(@RequestBody SaveTaskRequestDTO body) {
        saveTaskUseCase.execute(body);
        try {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
}
