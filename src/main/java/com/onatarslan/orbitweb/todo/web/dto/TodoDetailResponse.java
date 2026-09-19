package com.onatarslan.orbitweb.todo.web.dto;


import com.onatarslan.orbitweb.todo.TodoStatus;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record TodoDetailResponse(
        UUID id,
        UUID projectId,
        String title,
        String description,
        TodoStatus status,
        LocalDate dueDate,
        Instant createdAt,
        Instant updatedAt
) {
}