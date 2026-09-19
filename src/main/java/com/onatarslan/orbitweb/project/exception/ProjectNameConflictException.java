package com.onatarslan.orbitweb.project.exception;

public class ProjectNameConflictException extends RuntimeException {

    private final String projectName;


    public ProjectNameConflictException(String projectName) {
        super("project name already exists: " + projectName);
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }
}
