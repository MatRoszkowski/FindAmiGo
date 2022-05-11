package com.mateuszroszkowski.FindAmiGo.repository;

import com.mateuszroszkowski.FindAmiGo.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
