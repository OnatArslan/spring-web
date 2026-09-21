package com.onatarslan.orbitweb.todo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.onatarslan.orbitweb.todo.TodoStatus;

import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TodoSummaryResponse(
        @JsonProperty("todoId")
        UUID id,
        String title,
        TodoStatus status,
        LocalDate dueDate
) {
}
