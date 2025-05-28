package org.example.spbootpr1.project;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String name;
    private String documentPath;
    private List<ProjectColumnDTO> projectColumnDTOs;
    private String createdAt;
}
