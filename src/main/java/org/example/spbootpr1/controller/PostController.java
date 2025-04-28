package org.example.spbootpr1.controller;

import lombok.RequiredArgsConstructor;
import org.example.spbootpr1.dto.PostCreateDTO;
import org.example.spbootpr1.entity.Post;
import org.example.spbootpr1.hateoas.PostModelAssembler;
import org.example.spbootpr1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final PostModelAssembler postModelAssembler;
    private final PagedResourcesAssembler<Post> pagedResourcesAssembler;  // ✅

    @GetMapping("/{id}")
    public EntityModel<Post> getPostById(@PathVariable Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return postModelAssembler.toModel(post);
    }

    @GetMapping
    public CollectionModel<EntityModel<Post>> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return postModelAssembler.toCollectionModel(posts);
    }

    @GetMapping("/page")
    public PagedModel<EntityModel<Post>> getAllPostsWithPage(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Post> postPage = postRepository.findAll(pageable);
        return pagedResourcesAssembler.toModel(postPage, postModelAssembler );
    }
}