package com.example.timelyapp.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> findById(int id){return projectRepository.findById(id);}

    public void deleteById(int id){
        projectRepository.deleteById(id);
    }
}
