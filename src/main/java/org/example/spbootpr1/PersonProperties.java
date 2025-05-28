package org.example.spbootpr1;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "example")
public class PersonProperties {
    private Person person;


}
