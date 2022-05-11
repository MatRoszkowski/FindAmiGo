package com.mateuszroszkowski.FindAmiGo.service.implementation;

import com.mateuszroszkowski.FindAmiGo.dto.PostDto;
import com.mateuszroszkowski.FindAmiGo.mapper.PostMapper;
import com.mateuszroszkowski.FindAmiGo.model.Post;
import com.mateuszroszkowski.FindAmiGo.model.User;
import com.mateuszroszkowski.FindAmiGo.repository.PostRepository;
import com.mateuszroszkowski.FindAmiGo.repository.UserRepository;
import com.mateuszroszkowski.FindAmiGo.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = postMapper.map(postDto);
        return postMapper.map(postRepository.save(post));
    }

    @Override
    public List<PostDto> getUserPosts(Long id) {
        List<Post> posts = postRepository.findPostsByPosterId(id);
        List<PostDto> postDtoList = new ArrayList<>();
        posts.forEach(post -> postDtoList.add(postMapper.map(post)));
        return postDtoList;
    }

    @Override
    public List<PostDto> getObservedPosts(Long userId) {
        User user = userRepository.getById(userId);
        List<Post> postList = new ArrayList<>(user.getObservedPosts());
        List<PostDto> postDtoList = new ArrayList<>();
        postList.forEach(post -> postDtoList.add(postMapper.map(post)));
        return postDtoList;
    }

    @Override
    public Boolean unfollowPost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        Collection<Post> postsObserved = user.getObservedPosts();
        postsObserved.remove(post);
        user.setObservedPosts(postsObserved);
        userRepository.save(user);

        Collection<User> observers = post.getObservers();
        observers.remove(user);
        post.setObservers(observers);
        postRepository.save(post);
        return true;
    }

    @Override
    public Boolean deletePost(Long postId) {
        try {
            Post post = postRepository.findById(postId).orElseThrow();
            Set<User> observers = new HashSet<>(post.getObservers());
            observers.forEach(user -> user.getObservedPosts().remove(post));
            observers.clear();
            post.setObservers(observers);
            post.setOriginalPoster(null);
            post.setSport(null);
            postRepository.save(post);

            Post post1 = postRepository.findById(postId).orElseThrow();
            postRepository.delete(post1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PostDto observePost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        Collection<Post> postsObserved = user.getObservedPosts();
        postsObserved.add(post);
        user.setObservedPosts(postsObserved);
        userRepository.save(user);

        Collection<User> observers = post.getObservers();
        observers.add(user);
        post.setObservers(observers);
        postRepository.save(post);
        return postMapper.map(post);
    }
}
