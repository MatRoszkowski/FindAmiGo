package com.mateuszroszkowski.FindAmiGo.controller;

import com.mateuszroszkowski.FindAmiGo.dto.UserDto;
import com.mateuszroszkowski.FindAmiGo.model.User;
import com.mateuszroszkowski.FindAmiGo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public List<User> getUsers(@RequestParam int size, int pageNumber) {
        return userService.getUsers(size, pageNumber);
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDto userDto) {
        log.info("register method called");
        try {
            userService.saveUser(userDto);
        } catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
    }
    @PostMapping("/update")
    public void updateUser(@RequestBody UserDto userDto){
        updateUser(userDto);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
    }
}
