package com.example.painter.companion.service;

import com.example.painter.companion.dto.AuthResponseDTO;
import com.example.painter.companion.dto.UserRegisterDTO;
import com.example.painter.companion.dto.UserLoginDTO;

public interface AuthService {
    AuthResponseDTO registerUser(UserRegisterDTO dto);
    AuthResponseDTO loginUser(UserLoginDTO dto);
}
