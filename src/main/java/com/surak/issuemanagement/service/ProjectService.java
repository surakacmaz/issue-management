package com.surak.issuemanagement.service;

import com.surak.issuemanagement.dto.ProjectDto;
import com.surak.issuemanagement.entity.Project;
import com.surak.issuemanagement.util.TPage;

import java.awt.print.Pageable;
import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto user);

    ProjectDto getById(long id);

    ProjectDto getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(ProjectDto project);
}
