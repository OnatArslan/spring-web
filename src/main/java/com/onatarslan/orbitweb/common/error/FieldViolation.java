package com.onatarslan.orbitweb.common.error;

public record FieldViolation(
        String field,
        String code,
        String message
) {
}
