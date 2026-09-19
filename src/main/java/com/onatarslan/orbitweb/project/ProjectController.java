package com.onatarslan.orbitweb.project;

import com.onatarslan.orbitweb.project.dto.CreateProjectRequest;
import com.onatarslan.orbitweb.project.dto.ProjectResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> getProject(
            @PathVariable(required = true, name = "projectId") UUID projectId
    ) {
        // no need for required true and name here but I added for example purpose

        return projectService.findById(projectId)
                .map(ProjectWebMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectResponse> createProject(
            @Valid @RequestBody CreateProjectRequest request
    ) {

        Project project = projectService.create(request.name().strip());

        ProjectResponse response = ProjectWebMapper.toResponse(project);

        URI location = URI.create("api/v1/projects" + response.id());

        return ResponseEntity.created(location).body(response);
    }

}
