package com.onatarslan.orbitweb.project.web;

import com.onatarslan.orbitweb.project.Project;
import com.onatarslan.orbitweb.project.ProjectService;
import com.onatarslan.orbitweb.project.web.dto.CreateProjectRequest;
import com.onatarslan.orbitweb.project.web.dto.ProjectResponse;
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
                .map(ProjectResponse::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectResponse> createProject(
            @RequestBody() CreateProjectRequest request
    ) {

        Project project = projectService.create(request.name());

        ProjectResponse response = ProjectResponse.from(project);

        URI location = URI.create("api/v1/projects" + response.id());

        return ResponseEntity.created(location).body(response);
    }

}
