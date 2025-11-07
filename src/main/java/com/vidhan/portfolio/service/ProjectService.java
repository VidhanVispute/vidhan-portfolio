package com.vidhan.portfolio.service;

import com.vidhan.portfolio.entity.Project;
import com.vidhan.portfolio.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    
    private final ProjectRepository projectRepository;
    
    public List<Project> getAllProjects() {
        return projectRepository.findAllByOrderByDisplayOrderAsc();
    }
    
    public List<Project> getFeaturedProjects() {
        return projectRepository.findByIsFeaturedTrue();
    }
    
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }
    
    public Project saveProject(Project project) {
        if (project.getDisplayOrder() == null) {
            project.setDisplayOrder(projectRepository.findAll().size() + 1);
        }
        return projectRepository.save(project);
    }
    
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}