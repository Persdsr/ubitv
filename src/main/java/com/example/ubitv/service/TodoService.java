package com.example.ubitv.service;

import com.example.ubitv.entity.TodoEntity;
import com.example.ubitv.entity.UserEntity;
import com.example.ubitv.model.Todo;
import com.example.ubitv.repository.TodoRepo;
import com.example.ubitv.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public List<TodoEntity> getAllTodos() {
        return todoRepo.findAll();
    }

    public Todo create(Long id, TodoEntity todo) {
        UserEntity user = userRepo.findById(id).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }

    // PRIIIIVVV
}
