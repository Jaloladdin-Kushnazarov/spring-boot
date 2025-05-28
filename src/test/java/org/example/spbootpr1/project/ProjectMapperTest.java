package org.example.spbootpr1.project;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.example.spbootpr1.project.ProjectMapper.PROJECT_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class ProjectMapperTest {

    @Test
    void toDTO() {
        Project project = new Project("1","Java Backend learning", Path.of("https://online.pdp.uz"), null, null);
        ProjectDTO dto = PROJECT_MAPPER.toDTO(project);
        System.out.println(dto);
    }

    @Test
    void toDTO2() {
        List<ProjectColumn> projectColumns = new ArrayList<>(List.of(
                new ProjectColumn("1", "Todo", 1, LocalDateTime.now()),
                new ProjectColumn("2", "In Progress", 2, LocalDateTime.now()),
                new ProjectColumn("3", "Done", 3, LocalDateTime.now())
        ));

        Project project = new Project("1", "Java Backend learning", Path.of("https://online.pdp.uz"), projectColumns, LocalDateTime.now());
        ProjectDTO dto = PROJECT_MAPPER.toDTO(project);
        System.out.println(dto);
    }
}