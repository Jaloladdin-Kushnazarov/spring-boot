package org.example.spbootpr1.entity;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Todo}
 */
@Value
public class TodoDto implements Serializable {
    String title;
}