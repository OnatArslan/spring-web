package com.onatarslan.orbitweb.project;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;


    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Transactional(readOnly = true)
    public Optional<Project> findById(UUID projectId) {
        return projectRepository.findById(projectId);
    }

}
