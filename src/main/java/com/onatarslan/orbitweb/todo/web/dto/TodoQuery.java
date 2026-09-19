package com.onatarslan.orbitweb.todo.web.dto;


import com.onatarslan.orbitweb.todo.TodoStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public record TodoQuery(
        TodoStatus status,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate dueBefore,

        Integer page,

        Integer size,
        List<String> sort
) {
}
