package com.mateuszroszkowski.FindAmiGo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResetPasswordDto {
    private Long userId;
    private String newPassword;
}
