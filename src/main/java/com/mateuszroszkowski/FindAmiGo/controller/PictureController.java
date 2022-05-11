package com.mateuszroszkowski.FindAmiGo.controller;

import com.mateuszroszkowski.FindAmiGo.dto.PictureDto;
import com.mateuszroszkowski.FindAmiGo.service.PictureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pictures")
@AllArgsConstructor
@Slf4j
public class PictureController {
    private final PictureService pictureService;

    @PostMapping("/")
    public void add(@RequestBody PictureDto pictureDto) {
        pictureService.addPicture(pictureDto);
    }

    @GetMapping("/{id}")
    public PictureDto getPicture(@PathVariable Long id) {
        return pictureService.getPicture(id);
    }
}
