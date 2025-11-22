package com.seuprojeto.mopo.service;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateClientRequestDTO;
import com.seuprojeto.mopo.dto.response.ClientResponseDTO;
import com.seuprojeto.mopo.model.Client;
import com.seuprojeto.mopo.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private IClientRepository repository;

    public ClientResponseDTO create(CreateOrUpdateClientRequestDTO dto) {
        var entity = Client.builder()
                .name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .telephone(dto.telephone())
                .cpf(dto.cpf())
                .dateOfBirth(dto.birthday())
                .build();

        var response = repository.save(entity);
        return new ClientResponseDTO(response);
    }

    public List<ClientResponseDTO> readAll() {
        return repository.findAll()
                .stream().map(ClientResponseDTO::new)
                .collect(Collectors.toList());
    }
}
