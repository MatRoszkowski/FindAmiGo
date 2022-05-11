package com.mateuszroszkowski.FindAmiGo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PictureDto {

    private Long id;
    private String filename;
    private byte[] photo;
}
