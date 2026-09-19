package com.onatarslan.orbitweb.common.error;


import com.onatarslan.orbitweb.project.exception.ProjectNameConflictException;
import com.onatarslan.orbitweb.project.exception.ProjectNotFoundException;
import com.onatarslan.orbitweb.todo.exception.InvalidTodoStatusTransitionException;
import com.onatarslan.orbitweb.todo.exception.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProjectNotFoundException.class)
    public ProblemDetail handleProjectNotFoundException(ProjectNotFoundException exception) {
        return createProblem(
                HttpStatus.NOT_FOUND,
                "Project not found",
                "PROJECT_NOT_FOUND",
                "Project '%s' not found".formatted(exception.getProjectId()),
                "project-not-found"
        );
    }

    @ExceptionHandler(TodoNotFoundException.class)
    ProblemDetail handleTodoNotFound(
            TodoNotFoundException exception
    ) {
        return createProblem(
                HttpStatus.NOT_FOUND,
                "Todo not found",
                "TODO_NOT_FOUND",
                "Todo '%s' was not found."
                        .formatted(exception.getTodoId()),
                "todo-not-found"
        );
    }

    @ExceptionHandler(ProjectNameConflictException.class)
    ProblemDetail handleProjectNameConflict(
            ProjectNameConflictException exception
    ) {
        return createProblem(
                HttpStatus.CONFLICT,
                "Project name conflict",
                "PROJECT_NAME_CONFLICT",
                "A project with the given name already exists.",
                "project-name-conflict"
        );
    }

    @ExceptionHandler(InvalidTodoStatusTransitionException.class)
    ProblemDetail handleInvalidTodoStatusTransition(
            InvalidTodoStatusTransitionException exception
    ) {
        return createProblem(
                HttpStatus.UNPROCESSABLE_CONTENT,
                "Invalid todo status transition",
                "INVALID_TODO_STATUS_TRANSITION",
                "The requested todo status transition is not allowed.",
                "invalid-todo-status-transition"
        );
    }

    private ProblemDetail createProblem(
            HttpStatus status,
            String title,
            String code,
            String detail,
            String type
    ) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, detail);
        problem.setTitle(title);
        problem.setType(
                URI.create("urn:orbit:error:" + type)
        );
        problem.setProperty("code", code);
        problem.setProperty("occuredAt", Instant.now());
        return problem;
    }

}
