package com.example.painter.companion.service;

import com.example.painter.companion.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDTO createUser(UserResponseDTO userResponseDTO);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
    void deleteUser(Long id);

    Optional<UserResponseDTO> findByEmail(String email);
}
