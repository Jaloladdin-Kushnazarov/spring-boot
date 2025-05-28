package org.example.spbootpr1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.spbootpr1.PostMapper.POST_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostMapper postMapper;

    @PostMapping
    public Post create(@RequestBody  PostCreateDTO postCreateDTO) {
        System.out.println(postCreateDTO);
        Post post = postMapper.fromDTO(postCreateDTO);
        return post;
    }
}
