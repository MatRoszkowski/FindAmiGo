package com.mateuszroszkowski.FindAmiGo.dto;

import com.mateuszroszkowski.FindAmiGo.model.Location;
import com.mateuszroszkowski.FindAmiGo.model.Picture;
import com.mateuszroszkowski.FindAmiGo.model.Post;
import com.mateuszroszkowski.FindAmiGo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String username;
    private String password;
    private String aboutMe;
    private Integer age;
    private Picture profileImage;
    private Collection<Post> observedPosts  = new HashSet<>();
    private Collection<Role> roles = new ArrayList<>();
}
