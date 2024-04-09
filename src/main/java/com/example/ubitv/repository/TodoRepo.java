package com.example.ubitv.repository;

import com.example.ubitv.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoEntity, Long> {
}
