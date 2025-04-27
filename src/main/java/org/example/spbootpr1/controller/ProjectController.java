package org.example.spbootpr1.controller;

import lombok.RequiredArgsConstructor;
import org.example.spbootpr1.entity.Project;
import org.example.spbootpr1.mapper.ProjectMapper;
import org.example.spbootpr1.projection.classbased.ProjectCreateDTO;
import org.example.spbootpr1.projection.classbased.ProjectDTO;
import org.example.spbootpr1.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project")
public class ProjectController {


    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;


    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


    @GetMapping("/dto")
    public List<ProjectDTO> getAllProjectDTOs() {
        List<Project> projects = projectRepository.findAll();
        return projectMapper.toDto(projects);
    }


    @PostMapping
    public Project createProject(@RequestBody ProjectCreateDTO dto) {
        Project project = projectMapper.fromCreateDTO(dto);
        project.setCode(project.getName().replace(" ", "_").toUpperCase());
        projectRepository.save(project);
        return project;
    }


}
