package com.surak.issuemanagement.service.impl;

import com.surak.issuemanagement.dto.ProjectDto;
import com.surak.issuemanagement.entity.Project;
import com.surak.issuemanagement.repository.ProjectRepository;
import com.surak.issuemanagement.service.ProjectService;
import com.surak.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {

        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProjectDto save(ProjectDto project) {
        Project projectCheck = (Project) projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck==null){
            throw new IllegalArgumentException("Project code already exist!");
        }

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }


    @Override
    public ProjectDto getById(long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {

        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {

        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {

        return null;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }
}
