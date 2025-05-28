package org.example.spbootpr1;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PostCreateDTO {
    private String title;
    private String body  ;
}
