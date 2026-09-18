package com.onatarslan.orbitweb.todo.web.dto;

import com.onatarslan.orbitweb.todo.Todo;
import com.onatarslan.orbitweb.todo.TodoStatus;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record TodoResponse(
        UUID id,
        String title,
        String description,
        TodoStatus status,
        LocalDate dueDate,
        Instant createdAt,
        Instant updatedAt
) {

    public static TodoResponse from(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getStatus(),
                todo.getDueDate(),
                todo.getCreatedAt(),
                todo.getUpdatedAt()
        );
    }

}
