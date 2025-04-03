package org.example.spbootpr1.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "jl")
public class Mail {
    private String username;
    private String password;
    private String email;

}
