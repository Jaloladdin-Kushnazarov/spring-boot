package org.example.spbootpr1;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);

    Post fromDTO(PostCreateDTO postCreateDTO);

    PostCreateDTO toDTO(Post post);
}
