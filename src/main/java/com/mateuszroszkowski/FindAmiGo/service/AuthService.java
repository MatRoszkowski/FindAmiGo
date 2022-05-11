package com.mateuszroszkowski.FindAmiGo.service;

import com.mateuszroszkowski.FindAmiGo.dto.ResetPasswordDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AuthService {
    void refreshToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException;
    void resetPassword(ResetPasswordDto resetPasswordDto);
}
