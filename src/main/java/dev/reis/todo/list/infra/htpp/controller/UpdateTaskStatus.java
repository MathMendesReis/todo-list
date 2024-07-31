package dev.reis.todo.list.infra.htpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.reis.todo.list.domain.task.dto.UpdateStatusDTO;
import dev.reis.todo.list.domain.task.usecase.UpdateStatusTaskUSeCase;

@RestController
@RequestMapping("task")
public class UpdateTaskStatus {

    @Autowired
    private UpdateStatusTaskUSeCase updateTaskUSeCase;

     @PutMapping("status/{postId}")
    public ResponseEntity<?> handle(@PathVariable String postId, @RequestBody UpdateStatusDTO body) {
         updateTaskUSeCase.execute(postId, body);
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
