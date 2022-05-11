package com.mateuszroszkowski.FindAmiGo.mapper;

import com.mateuszroszkowski.FindAmiGo.dto.UserDto;
import com.mateuszroszkowski.FindAmiGo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .aboutMe(userDto.getAboutMe())
                .age(userDto.getAge())
                .profileImage(userDto.getProfileImage())
                .observedPosts(userDto.getObservedPosts())
                .roles(userDto.getRoles())
                .build();
    }

    public UserDto map(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .aboutMe(user.getAboutMe())
                .age(user.getAge())
                .profileImage(user.getProfileImage())
                .observedPosts(user.getObservedPosts())
                .roles(user.getRoles())
                .build();
    }
}
