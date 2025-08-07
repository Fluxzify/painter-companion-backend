package com.example.painter.companion.service.impl;

import com.example.painter.companion.dto.AuthResponseDTO;
import com.example.painter.companion.dto.UserRegisterDTO;
import com.example.painter.companion.dto.UserLoginDTO;
import com.example.painter.companion.dto.UserResponseDTO;
import com.example.painter.companion.model.User;
import com.example.painter.companion.repository.UserRepository;
import com.example.painter.companion.service.AuthService;
import com.example.painter.companion.config.JwtService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService JwtService;

    @Override
    public AuthResponseDTO registerUser(UserRegisterDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(user);

        String token = JwtService.generateToken(user.getEmail());

        UserResponseDTO userDTO = new UserResponseDTO(user.getId(), user.getName(), user.getEmail());

        return new AuthResponseDTO(token, userDTO);
    }

    @Override
    public AuthResponseDTO loginUser(UserLoginDTO dto) {
        Optional<User> optionalUser = userRepository.findByEmail(dto.getEmail());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = JwtService.generateToken(user.getEmail());

        UserResponseDTO userDTO = new UserResponseDTO(user.getId(), user.getName(), user.getEmail());

        return new AuthResponseDTO(token, userDTO);
    }
}
