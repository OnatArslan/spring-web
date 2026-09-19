package com.onatarslan.orbitweb.project;

import com.onatarslan.orbitweb.project.dto.ProjectResponse;

public class ProjectWebMapper {

    private ProjectWebMapper() {

    }


    static ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getCreatedAt(),
                project.getUpdatedAt()
        );
    }

}
