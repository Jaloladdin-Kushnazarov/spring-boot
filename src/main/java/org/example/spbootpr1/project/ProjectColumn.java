package org.example.spbootpr1.project;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectColumn {
    private String id;
    private String name;
    private Integer order;
    private LocalDateTime createdAt;
}
