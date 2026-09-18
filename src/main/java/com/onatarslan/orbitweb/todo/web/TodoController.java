package com.onatarslan.orbitweb.todo.web;

import com.onatarslan.orbitweb.todo.Todo;
import com.onatarslan.orbitweb.todo.TodoStatus;
import com.onatarslan.orbitweb.todo.web.dto.CreateTodoRequest;
import com.onatarslan.orbitweb.todo.web.dto.TodoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class TodoController {


    @GetMapping("/projects/{projectId}/todos")
    public List<Todo> getProjectTodos(
            @PathVariable(required = false) UUID projectId,

            @RequestParam(name = "status", required = false)
            List<TodoStatus> statuses,

            @RequestParam(name = "page", defaultValue = "0")
            int page,

            @RequestParam(name = "size", defaultValue = "20")
            int size,

            @RequestParam(name = "sort", required = false)
            List<String> sort
    ) {
        return List.of();
    }


    @PostMapping("/projects/{projectId}/todos")
    public ResponseEntity<TodoResponse> createTodo(
            @PathVariable UUID projectId,
            @RequestBody CreateTodoRequest request
    ) {

    }


}
