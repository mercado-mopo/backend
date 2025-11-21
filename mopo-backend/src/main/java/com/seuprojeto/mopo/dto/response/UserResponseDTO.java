package com.seuprojeto.mopo.dto.response;

import com.seuprojeto.mopo.model.shared.User;

import java.util.UUID;

public record UserResponseDTO(UUID id, String nome, String email, String telephone) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getTelephone());
    }
}
