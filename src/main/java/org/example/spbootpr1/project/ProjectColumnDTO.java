package org.example.spbootpr1.project;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectColumnDTO {
    private String pc_name;
    private String pc_order;
    private LocalDateTime pc_createdAt;

}
