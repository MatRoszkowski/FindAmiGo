package com.mateuszroszkowski.FindAmiGo.mapper;

import com.mateuszroszkowski.FindAmiGo.dto.PostDto;
import com.mateuszroszkowski.FindAmiGo.dto.UserDto;
import com.mateuszroszkowski.FindAmiGo.model.Post;
import com.mateuszroszkowski.FindAmiGo.model.User;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public Post map(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .description(postDto.getDescription())
                .createDate(postDto.getCreateDate())
                .location(postDto.getLocation())
                .sport(postDto.getSport())
                .originalPoster(postDto.getOriginalPoster())
                .observers(postDto.getObservers())
                .build();
    }

    public PostDto map(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .description(post.getDescription())
                .createDate(post.getCreateDate())
                .location(post.getLocation())
                .sport(post.getSport())
                .originalPoster(post.getOriginalPoster())
                .observers(post.getObservers())
                .build();
    }
}
