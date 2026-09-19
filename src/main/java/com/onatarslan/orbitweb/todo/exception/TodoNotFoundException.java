package com.onatarslan.orbitweb.todo.exception;

import java.util.UUID;

public class TodoNotFoundException extends RuntimeException {

    private final UUID todoId;

    public TodoNotFoundException(UUID todoId) {
        super("todo not found with id: " + todoId);
        this.todoId = todoId;
    }


    public UUID getTodoId() {
        return todoId;
    }

}
