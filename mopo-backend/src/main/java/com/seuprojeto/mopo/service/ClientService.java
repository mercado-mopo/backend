package com.seuprojeto.mopo.service;

import com.seuprojeto.mopo.dto.response.ClientResponseDTO;
import com.seuprojeto.mopo.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private IClientRepository repository;

    public List<ClientResponseDTO> readAll() {
        return repository.findAll()
                .stream().map(ClientResponseDTO::new)
                .collect(Collectors.toList());
    }
}
