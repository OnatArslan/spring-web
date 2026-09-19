package com.onatarslan.orbitweb.todo.web;

import com.onatarslan.orbitweb.todo.Todo;
import com.onatarslan.orbitweb.todo.web.dto.TodoDetailResponse;
import com.onatarslan.orbitweb.todo.web.dto.TodoSummaryResponse;

public class TodoWebMapper {

    private TodoWebMapper() {

    }

    static TodoSummaryResponse toSummaryResponse(Todo todo) {
        return new TodoSummaryResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getStatus(),
                todo.getDueDate()
        );
    }

    static TodoDetailResponse toDetailResponse(Todo todo) {
        return new TodoDetailResponse(
                todo.getId(),
                todo.getProject().getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getStatus(),
                todo.getDueDate(),
                todo.getCreatedAt(),
                todo.getUpdatedAt()
        );
    }

}
