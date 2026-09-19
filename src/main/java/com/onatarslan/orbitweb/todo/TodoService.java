package com.onatarslan.orbitweb.todo;

import com.onatarslan.orbitweb.project.Project;
import com.onatarslan.orbitweb.project.ProjectRepository;
import com.onatarslan.orbitweb.todo.exception.TodoNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final ProjectRepository projectRepository;

    public TodoService(TodoRepository todoRepository, ProjectRepository projectRepository) {
        this.todoRepository = todoRepository;
        this.projectRepository = projectRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Todo> findById(UUID todoId) {
        return todoRepository.findById(todoId);
    }


    @Transactional
    public Todo create(String title, String description, TodoStatus status, LocalDate dueDate, UUID projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new TodoNotFoundException(projectId));

        Instant now = Instant.now();

        Todo todo = new Todo(project,
                title,
                description,
                status,
                now,
                now,
                dueDate
        );

        return todoRepository.save(todo);
    }


}
