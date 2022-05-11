package com.mateuszroszkowski.FindAmiGo.service;

import com.mateuszroszkowski.FindAmiGo.dto.UserDto;
import com.mateuszroszkowski.FindAmiGo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(UserDto userDto);

    User getUser(String username);

    List<User> getUsers(int size, int page);

    void updateUser(UserDto userDto);

    void deleteUser(Long id);
}
