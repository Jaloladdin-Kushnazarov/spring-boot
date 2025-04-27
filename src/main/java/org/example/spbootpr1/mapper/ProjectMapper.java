package org.example.spbootpr1.mapper;

import org.example.spbootpr1.projection.classbased.ProjectCreateDTO;
import org.example.spbootpr1.entity.Project;
import org.example.spbootpr1.projection.classbased.ProjectDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    Project toEntity(ProjectDTO projectDTO);

    ProjectDTO toDto(Project project);

    List<ProjectDTO> toDto(List<Project> projects);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectDTO projectDTO, @MappingTarget Project project);

    Project fromCreateDTO(ProjectCreateDTO projectCreateDTO);


}