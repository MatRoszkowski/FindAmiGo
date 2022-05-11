package com.mateuszroszkowski.FindAmiGo.repository;

import com.mateuszroszkowski.FindAmiGo.model.Sport;
import com.mateuszroszkowski.FindAmiGo.model.SportName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
    Sport findBySportName(SportName sportName);
}
