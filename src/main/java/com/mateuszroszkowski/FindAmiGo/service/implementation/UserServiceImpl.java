package com.mateuszroszkowski.FindAmiGo.service.implementation;

import com.mateuszroszkowski.FindAmiGo.dto.UserDto;
import com.mateuszroszkowski.FindAmiGo.exception.PasswordNotSufficientException;
import com.mateuszroszkowski.FindAmiGo.mapper.UserMapper;
import com.mateuszroszkowski.FindAmiGo.model.Post;
import com.mateuszroszkowski.FindAmiGo.model.User;
import com.mateuszroszkowski.FindAmiGo.repository.PostRepository;
import com.mateuszroszkowski.FindAmiGo.repository.UserRepository;
import com.mateuszroszkowski.FindAmiGo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final PostRepository postRepository;

    @Override
    public void saveUser(UserDto userDto) {
        try {
            isSufficientPassword(userDto.getPassword());
            User user = userMapper.map(userDto);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(user);
            log.info("User: " + user.getUsername() + " saved successfully");
        } catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers(int size, int pageNumber) {
        Page<User> page = userRepository.findAll(Pageable.ofSize(size).withPage(pageNumber));
        return page.getContent();
    }

    private void isSufficientPassword(String password) {
        if (password == null) {
            throw new PasswordNotSufficientException("Password can not be null");
        } else if (password.length() < 8) {
            throw new PasswordNotSufficientException("Password to short. Should contain at least 8 characters.");
        } else if (password.matches("[0-9]+")) {
            throw new PasswordNotSufficientException("Password should contain digits");
        } else if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")) {
            throw new PasswordNotSufficientException("Password should contain at least one capital letter and one lowercase letter");
        }
    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = userMapper.map(userDto);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        try {
            User user = userRepository.findById(id).orElseThrow();
            List<Post> posts = new ArrayList<>(user.getObservedPosts());
            for (int i = 0; i < posts.size(); i++) {
                posts.get(i).getObservers().remove(user);
            }
            user.getObservedPosts().clear();
            List<Post> allUsersPosts = postRepository.findPostsByPosterId(id);
            user.setRoles(null);
            user.setProfileImage(null);
            userRepository.save(user);
            userRepository.deleteById(id);
        } catch (Exception e) {
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        } else {
            log.info("User found: " + username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
