package com.mateuszroszkowski.FindAmiGo.service;

import com.mateuszroszkowski.FindAmiGo.dto.PictureDto;

public interface PictureService {
    void addPicture(PictureDto pictureDto);
    PictureDto getPicture(Long id);
}
