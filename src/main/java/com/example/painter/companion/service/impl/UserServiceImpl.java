package com.example.painter.companion.service.impl;

import com.example.painter.companion.dto.UserResponseDTO;
import com.example.painter.companion.mapper.UserMapper;
import com.example.painter.companion.model.User;
import com.example.painter.companion.repository.UserRepository;
import com.example.painter.companion.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO createUser(UserResponseDTO userResponseDTO) {
        User user = userMapper.toEntity(userResponseDTO);

        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserResponseDTO> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDTO);
    }
}
