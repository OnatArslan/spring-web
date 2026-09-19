package com.onatarslan.orbitweb.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateProjectRequest(

        @NotBlank
        @Size(max = 10)
        String name
) {
}
