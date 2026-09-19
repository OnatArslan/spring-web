package com.onatarslan.orbitweb.todo;

import com.onatarslan.orbitweb.todo.dto.CreateTodoRequest;
import com.onatarslan.orbitweb.todo.dto.TodoDetailResponse;
import com.onatarslan.orbitweb.todo.dto.TodoQuery;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

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
        Todo todo = todoService.create(
                request.title(),
                request.description(),
                request.status(),
                request.dueDate()
                , projectId);
        TodoDetailResponse todoDetailResponse = TodoWebMapper.toDetailResponse(todo);

        URI uri = URI.create("api/v1/projects/" + projectId + "/todos" + todoDetailResponse.id());

        return ResponseEntity.created(uri).body(todoDetailResponse);

    }


}
