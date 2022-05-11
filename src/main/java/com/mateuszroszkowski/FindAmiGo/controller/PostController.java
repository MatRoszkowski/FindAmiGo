package com.mateuszroszkowski.FindAmiGo.controller;

import com.mateuszroszkowski.FindAmiGo.dto.PostDto;
import com.mateuszroszkowski.FindAmiGo.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @GetMapping("/getUserPosts/{userId}")
    public List<PostDto> getUserPosts(@PathVariable Long userId) {
        return postService.getUserPosts(userId);
    }

    @PostMapping("/observePost/{userId}/{postId}")
    public PostDto observePost(@PathVariable Long userId, @PathVariable Long postId) {
        return postService.observePost(userId, postId);
    }

    @PostMapping("/unfollowPost/{userId}/{postId}")
    public Boolean unfollowPost(@PathVariable Long userId, @PathVariable Long postId) {
        return postService.unfollowPost(userId, postId);
    }

    @GetMapping("/getObservedPosts/{userId}")
    public List<PostDto> getObservedPosts(@PathVariable Long userId) {
        return postService.getObservedPosts(userId);
    }

    @PostMapping("/createPost")
    public PostDto createPost(@RequestBody PostDto postDto) {
        try {
            return postService.createPost(postDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/deletePost/{postId}")
    public Boolean deletePost(@PathVariable Long postId) {
        return postService.deletePost(postId);
    }
}
