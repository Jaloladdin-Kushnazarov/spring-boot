package org.example.spbootpr1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class Spbootpr1Application {

    
    public static void main(String[] args) {
        SpringApplication.run(Spbootpr1Application.class, args);
    }

}
