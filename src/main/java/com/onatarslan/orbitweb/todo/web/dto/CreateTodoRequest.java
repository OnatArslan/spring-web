package com.onatarslan.orbitweb.todo.web.dto;

import com.onatarslan.orbitweb.todo.TodoStatus;

import java.time.LocalDate;

public record CreateTodoRequest(
        String title,
        String description,
        TodoStatus status,
        LocalDate dueDate
) {
}
