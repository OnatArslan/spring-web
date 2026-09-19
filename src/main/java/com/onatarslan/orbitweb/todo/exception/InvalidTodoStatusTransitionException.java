package com.onatarslan.orbitweb.todo.exception;

import com.onatarslan.orbitweb.todo.TodoStatus;

public class InvalidTodoStatusTransitionException extends RuntimeException {

    public InvalidTodoStatusTransitionException(TodoStatus oldStatus, TodoStatus newStatus) {
        super("can not set todo status from $s to $s".formatted(oldStatus, newStatus));
    }

}
