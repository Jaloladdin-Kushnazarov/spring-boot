package org.example.spbootpr1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link org.example.spbootpr1.entity.Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDTO implements Serializable {
    private Integer userId;
    private String title;
    private String body;
}