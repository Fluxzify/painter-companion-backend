package com.example.painter.companion.controller;

import com.example.painter.companion.dto.AuthResponseDTO;
import com.example.painter.companion.dto.UserResponseDTO;
import com.example.painter.companion.dto.UserLoginDTO;
import com.example.painter.companion.dto.UserRegisterDTO;
import com.example.painter.companion.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> loginUser(@RequestBody UserLoginDTO loginDTO) {
        AuthResponseDTO response = authService.loginUser(loginDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> registerUser(@RequestBody UserRegisterDTO registerDTO) {
        AuthResponseDTO response = authService.registerUser(registerDTO);
        return ResponseEntity.ok(response);
    }

}
