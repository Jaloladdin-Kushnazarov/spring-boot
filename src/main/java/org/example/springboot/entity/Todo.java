package org.example.springboot.entity;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private Integer id;

    @NotBlank
    private String title;


    @NotBlank
    @Size(min = 1, max = 3)
    private String priority;
}
