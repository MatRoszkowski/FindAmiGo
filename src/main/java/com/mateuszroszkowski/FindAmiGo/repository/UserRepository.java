package com.mateuszroszkowski.FindAmiGo.repository;

import com.mateuszroszkowski.FindAmiGo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
