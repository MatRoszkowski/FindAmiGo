package com.mateuszroszkowski.FindAmiGo.mapper;

import com.mateuszroszkowski.FindAmiGo.dto.PictureDto;
import com.mateuszroszkowski.FindAmiGo.dto.PostDto;
import com.mateuszroszkowski.FindAmiGo.model.Picture;
import com.mateuszroszkowski.FindAmiGo.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PictureMapper {
    public Picture map(PictureDto pictureDto) {
        return Picture.builder()
                .id(pictureDto.getId())
                .filename(pictureDto.getFilename())
                .photo(pictureDto.getPhoto())
                .build();
    }

    public PictureDto map(Picture picture) {
        return PictureDto.builder()
                .id(picture.getId())
                .filename(picture.getFilename())
                .photo(picture.getPhoto())
                .build();
    }
}
