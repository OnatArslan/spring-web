package com.onatarslan.orbitweb.project.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateProjectRequest(

        @NotBlank
        @Size(max = 10)
        String name
) {
}
