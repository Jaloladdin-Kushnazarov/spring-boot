package org.example.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class ObjectMapperTest {

    @Test
    void simpleCodeTest() throws JsonProcessingException {
        String postJson = """
                {
                  "userId": 1,
                  "id": 1,
                  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                  "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                }""";

        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(postJson, Post.class);
        System.out.println(post);
    }



    @Test
    void objectFromByteArray() throws Exception {
        byte[] bytes = """
                {
                  "userId": 1,
                  "id": 1,
                  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                  "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                }""".getBytes();

        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue  (bytes, Post.class);
        System.out.println(post);
    }





    @Test
    void objectFromFile() throws Exception {
        File file = new File("data/file.txt");
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(file, Post.class);
        System.out.println("FROM FILE:   \n" + post);
    }


    @Test
    void objectFromURL() throws Exception {
        int postId = new Random().nextInt(1, 10);
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/" + postId);
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(url, Post.class);
        System.out.println("FROM URL:   \n" + post);
    }



    @Test
    void dateFormat() throws Exception {
        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum|\nreprehenderit moles");
        post.setCreatedAt(LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String postJson = mapper.writeValueAsString(post);
        System.out.println(postJson);
    }

}
