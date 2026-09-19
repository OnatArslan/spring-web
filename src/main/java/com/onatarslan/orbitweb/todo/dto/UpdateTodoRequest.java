package com.onatarslan.orbitweb.todo.dto;

import com.onatarslan.orbitweb.todo.TodoStatus;

import java.time.LocalDate;

public record UpdateTodoRequest(
        String title,
        String description,
        TodoStatus status,
        LocalDate dueDate
) {
}