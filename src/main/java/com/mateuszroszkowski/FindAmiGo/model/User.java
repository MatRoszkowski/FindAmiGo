package com.mateuszroszkowski.FindAmiGo.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    private String aboutMe;
    private Integer age;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Picture profileImage;
    @ManyToMany(mappedBy = "observers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Post> observedPosts  = new HashSet<>();
    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

}
