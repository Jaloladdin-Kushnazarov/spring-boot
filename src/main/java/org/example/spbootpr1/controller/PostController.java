package org.example.spbootpr1.controller;

import lombok.RequiredArgsConstructor;
import org.example.spbootpr1.entity.Post;
import org.example.spbootpr1.projection.classbased.PostDTO;
import org.example.spbootpr1.projection.interfacebased.PostProjection;
import org.example.spbootpr1.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;


    @GetMapping
    public List<Post> getPosts() {
        return postRepository.findAll();
    }


    @GetMapping("/pages")
    public Page<Post> getPostsWithPage(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        Sort sort = Sort.by(Sort.Order.desc("title"), Sort.Order.asc("id"));
        Pageable pageable = PageRequest.of(page-1, size, sort);
        return postRepository.findAll(pageable);
    }


    @GetMapping("/{userId}")
    public List<Post> getByUserId(@PathVariable Long userId) {
        return postRepository.getAllPostsByUserId(userId);
    }

    @GetMapping("/sortbyid")
    public List<Post> getByUserId() {
        Sort sort = Sort.by(Sort.Direction.DESC, "title")
                .and(Sort.by(Sort.Direction.ASC, "id"));
        return postRepository.findAll(sort);
    }



    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long userId) {
        System.out.println(userId);
        postRepository.deletePostByUserId(userId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/i-projection")
    public List<PostProjection> getAllPostByInterfaceProjection() {
        return postRepository.findAllPostsByInterfaceProjection();
    }


    @GetMapping("/c-projection")
    public List<PostDTO> getAllPostByCLassProjection() {
        return postRepository.findAllPostsByClassProjection();
    }

}
