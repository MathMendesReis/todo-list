package dev.reis.todo.list.infra.htpp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.reis.todo.list.domain.task.dto.UpdateTaskDTO;
import dev.reis.todo.list.domain.task.usecase.UpdateTaskUSeCase;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("task")
public class UpdateTasController {
    @Autowired
    private UpdateTaskUSeCase updateTaskUSeCase;

    @PutMapping("/{postId}")
    public ResponseEntity<?> handle(@PathVariable String postId, @RequestBody UpdateTaskDTO body) {
         updateTaskUSeCase.execute(postId, body);
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
}