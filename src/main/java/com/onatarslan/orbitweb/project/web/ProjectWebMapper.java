package com.onatarslan.orbitweb.project.web;

import com.onatarslan.orbitweb.project.Project;
import com.onatarslan.orbitweb.project.web.dto.ProjectResponse;

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
