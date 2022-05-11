package com.mateuszroszkowski.FindAmiGo.dto;

import com.mateuszroszkowski.FindAmiGo.model.Location;
import com.mateuszroszkowski.FindAmiGo.model.Sport;
import com.mateuszroszkowski.FindAmiGo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostDto {
    private Long id;
    private String description;
    private Date createDate;
    private Location location;
    private Sport sport;
    private User originalPoster;
    private Collection<User> observers = new HashSet<>();
}
