package com.example.painter.companion.mapper;

import com.example.painter.companion.dto.UserResponseDTO;
import com.example.painter.companion.dto.UserLoginDTO;
import com.example.painter.companion.dto.UserRegisterDTO;
import com.example.painter.companion.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // para que Spring lo detecte como Bean
public interface UserMapper {


    UserResponseDTO toDTO(User user);

    User toEntity(UserResponseDTO dto);
    User toEntity(UserRegisterDTO dto);
    User toEntity(UserLoginDTO dto);

}