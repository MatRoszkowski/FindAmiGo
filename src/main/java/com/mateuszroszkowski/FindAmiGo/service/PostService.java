package com.mateuszroszkowski.FindAmiGo.service;

import com.mateuszroszkowski.FindAmiGo.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getUserPosts(Long id);

    PostDto createPost(PostDto postDto);

    List<PostDto> getObservedPosts(Long userId);

    Boolean unfollowPost(Long userId, Long postId);

    Boolean deletePost(Long postId);

    PostDto observePost(Long userId, Long postId);
}
