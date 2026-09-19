package com.onatarslan.orbitweb.todo.web;

import com.onatarslan.orbitweb.todo.web.dto.CreateTodoRequest;
import com.onatarslan.orbitweb.todo.web.dto.TodoDetailResponse;
import com.onatarslan.orbitweb.todo.web.dto.TodoQuery;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class TodoController {


    @GetMapping("/projects/{projectId}/todos")
    public List<TodoDetailResponse> getProjectTodos(
            @PathVariable(required = false) UUID projectId,

            @ModelAttribute TodoQuery query
    ) {
        return List.of();
    }


    @PostMapping("/projects/{projectId}/todos")
    public ResponseEntity<TodoDetailResponse> createTodo(
            @PathVariable UUID projectId,
            @Valid @RequestBody CreateTodoRequest request
    ) {

        return null;
    }


}
