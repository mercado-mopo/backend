package com.seuprojeto.mopo.dto.response;

import com.seuprojeto.mopo.model.shared.User;

import java.util.UUID;

public record UserResponseDTO(UUID id, String nome, String email, String telephone) {
    public UserResponseDTO(User entity) {
        this(entity.getId(), entity.getName(), entity.getEmail(), entity.getTelephone());
    }
}
