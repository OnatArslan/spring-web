package com.onatarslan.orbitweb.todo;

import com.onatarslan.orbitweb.project.Project;
import com.onatarslan.orbitweb.todo.web.dto.CreateTodoRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Todo> findById(UUID todoId) {
        return todoRepository.findById(todoId);
    }


    @Transactional
    public Todo create(CreateTodoRequest request, Project project) {
        // will implement nested logic
        return null;

    }


}
