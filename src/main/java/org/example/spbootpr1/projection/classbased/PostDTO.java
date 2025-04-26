package org.example.spbootpr1.projection.classbased;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class PostDTO {
    private final Long id;
    private final String title;

    public PostDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
