package com.example.timelyapp.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjects(){
        return projectService.getProjects();
    }

    @PostMapping
    public Project save(@RequestBody final Project project){
        return projectService.save(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> completeProject(@PathVariable(value = "id") int projectId,
                                                   @RequestBody Project completedProject) {

        Optional<Project> project = projectService.findById(projectId);

        project.ifPresent(p -> p.setName(completedProject.getName()));
        project.ifPresent(p -> p.setStop(completedProject.getStop()));
        project.ifPresent(p -> p.setDuration(completedProject.getDuration()));

        final Project finalProject = projectService.save(project.get());
        return ResponseEntity.ok(finalProject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        projectService.deleteById(id);
    }
}
