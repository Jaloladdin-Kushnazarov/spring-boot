package org.example.spbootpr1.car;

import lombok.AllArgsConstructor;
import lombok.ToString;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Car {
    private String id;
    private String name;
    private String maker;
    private Integer price;
}
