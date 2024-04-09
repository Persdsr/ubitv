package com.example.ubitv.controllers;

import com.example.ubitv.entity.TodoEntity;
import com.example.ubitv.exception.UserByIdNotFoundException;
import com.example.ubitv.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("")
    public ResponseEntity getAllTodo() {
        try {
            return ResponseEntity.ok(todoService.getAllTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("")
    public ResponseEntity createTodo(@RequestParam Long userId,
                                     @RequestBody TodoEntity todo) {
        try {
            return ResponseEntity.ok(todoService.create(userId, todo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
