package com.mateuszroszkowski.FindAmiGo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double latitude;//szerokość geograficzna
    @Column(nullable = false)
    private Double longitude;//długosć geograficzna
}
