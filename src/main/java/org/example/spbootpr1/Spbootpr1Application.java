package org.example.spbootpr1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@SpringBootApplication
public class Spbootpr1Application {

    public static void main(String[] args) {
        SpringApplication.run(Spbootpr1Application.class, args);

        System.out.println("commit Spring boot JPA  lesson");
    }

}
