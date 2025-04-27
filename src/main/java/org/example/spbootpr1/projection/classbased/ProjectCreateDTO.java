package org.example.spbootpr1.projection.classbased;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link org.example.spbootpr1.entity.Project}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCreateDTO implements Serializable {
    private String name;
}