package org.example.spbootpr1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.spbootpr1.entity.Post;
import org.example.spbootpr1.repository.PostRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.net.URL;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class Spbootpr1Application {

    public static void main(String[] args) {
        SpringApplication.run(Spbootpr1Application.class, args);

    }


//    @Bean
    public ApplicationRunner init(PostRepository postRepository, ObjectMapper objectMapper) {
        return args -> {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            List<Post> posts = objectMapper.readValue(url, new TypeReference<>() {
            });
            postRepository.saveAll(posts);
        };
    }


}
