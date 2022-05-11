package com.mateuszroszkowski.FindAmiGo.repository;

import com.mateuszroszkowski.FindAmiGo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT DISTINCT p FROM posts p WHERE (p.latitude BETWEEN ?1 and ?2) and p.longitude BETWEEN ?3 and ?4")
    List<Post> findPostsInSquare(Double minLatitude, Double maxLatitude, Double minLongitude, Double maxLongitude);

    @Query("SELECT DISTINCT p FROM posts p WHERE (p.latitude BETWEEN ?1 and ?2) and (p.longitude BETWEEN ?3 and ?4) and (p.sport.id = ?5)")
    List<Post> findPostsInSquareWithExactSport(Double minLatitude, Double maxLatitude, Double minLongitude, Double maxLongitude, Long sport);

    @Query("SELECT DISTINCT u.observedPosts FROM users u WHERE u.id = ?1")
    List<Post> findObservedPosts(Long id);

    @Query("SELECT DISTINCT p FROM posts p WHERE p.originalPoster.id = ?1")
    List<Post> findPostsByPosterId(Long id);
}
