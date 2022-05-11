package com.mateuszroszkowski.FindAmiGo.service.implementation;

import com.mateuszroszkowski.FindAmiGo.dto.PictureDto;
import com.mateuszroszkowski.FindAmiGo.mapper.PictureMapper;
import com.mateuszroszkowski.FindAmiGo.model.Picture;
import com.mateuszroszkowski.FindAmiGo.repository.PictureRepository;
import com.mateuszroszkowski.FindAmiGo.service.PictureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final PictureMapper pictureMapper;
    private final PictureRepository pictureRepository;


    @Override
    public void addPicture(PictureDto pictureDto) {
        Picture picture = pictureMapper.map(pictureDto);
    }

    @Override
    public PictureDto getPicture(Long id) {
        return pictureMapper.map(pictureRepository.getById(id));
    }
}
