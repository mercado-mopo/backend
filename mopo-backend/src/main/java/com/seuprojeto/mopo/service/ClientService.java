package com.seuprojeto.mopo.service;

import com.seuprojeto.mopo.dto.UserResponseDTO;
import com.seuprojeto.mopo.dto.request.CreateClientRequestDTO;
import com.seuprojeto.mopo.model.Client;
import com.seuprojeto.mopo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public UserResponseDTO create(CreateClientRequestDTO dto) {
        var entity = Client.builder().name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .cpf(dto.cpf())
                .dateOfBirth(dto.birthday())
                .build();

        var response = repository.save(entity);
        return new UserResponseDTO(response.getId(), response.getName(), response.getEmail(), response.getTelephone());
    }

    public List<Client> readAll() {
        return repository.findAll();
    }
}
