package com.mateuszroszkowski.FindAmiGo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class LocationDto {
    private Double latitude;//szerokość geograficzna
    private Double longitude;//długosć geograficzna
}
