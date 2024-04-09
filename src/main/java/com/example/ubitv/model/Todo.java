package com.example.ubitv.model;

import com.example.ubitv.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean complete;

    public static Todo toModel(TodoEntity todoEntity) {
        Todo todo = new Todo();
        todo.setId(todoEntity.getId());
        todo.setTitle(todoEntity.getTitle());
        todo.setComplete(todoEntity.getCompleted());

        return todo;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

}
