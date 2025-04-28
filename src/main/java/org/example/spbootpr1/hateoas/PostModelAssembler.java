package org.example.spbootpr1.hateoas;

import org.example.spbootpr1.controller.PostController;
import org.example.spbootpr1.entity.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public  class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {


    @Override
    public EntityModel<Post> toModel(Post post) {
        Link selfRel = linkTo(methodOn(PostController.class).getPostById(post.getId())).withSelfRel();
        Link postsLink = linkTo(methodOn(PostController.class).getAllPosts()).withRel("posts");
        return EntityModel.of(post, selfRel, postsLink);
    }


    @Override
    public CollectionModel<EntityModel<Post>> toCollectionModel(Iterable<? extends Post> entities) {
        List<EntityModel<Post>> models =new ArrayList<>();
        entities.forEach(post -> models.add(toModel(post)));
        Link postsLink = linkTo(methodOn(PostController.class).getAllPosts()).withSelfRel();
        return CollectionModel.of(models,postsLink);
    }


}
