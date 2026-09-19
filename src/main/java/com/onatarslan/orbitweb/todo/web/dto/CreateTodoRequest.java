package com.onatarslan.orbitweb.todo.web.dto;

import com.onatarslan.orbitweb.todo.TodoStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateTodoRequest(
        @NotBlank
        @Size(max = 200)
        String title,

        @Size(max = 1000)
        String description,

        @NotNull
        TodoStatus status,

        @Future // Future is for future date values and @Past is past values
        LocalDate dueDate
) {
}
