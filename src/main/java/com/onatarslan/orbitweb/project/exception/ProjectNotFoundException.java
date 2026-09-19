package com.onatarslan.orbitweb.project.exception;

import java.util.UUID;

public class ProjectNotFoundException extends RuntimeException {

    private final UUID projectId;

    public ProjectNotFoundException(UUID projectId) {
        super("project not found with id: " + projectId);
        this.projectId = projectId;
    }

    public UUID getProjectId() {
        return projectId;
    }
}
