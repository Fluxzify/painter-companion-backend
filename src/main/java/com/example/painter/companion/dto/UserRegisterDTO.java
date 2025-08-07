package com.example.painter.companion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterDTO {


    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
}
