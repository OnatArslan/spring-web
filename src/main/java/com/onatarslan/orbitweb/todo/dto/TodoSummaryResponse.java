package com.onatarslan.orbitweb.todo.dto;

import com.onatarslan.orbitweb.todo.TodoStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TodoSummaryResponse(
        UUID id,
        String title,
        TodoStatus status,
        LocalDate dueDate
) {
}
