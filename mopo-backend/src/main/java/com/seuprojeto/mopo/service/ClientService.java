package com.seuprojeto.mopo.service;

import com.seuprojeto.mopo.dto.ClientResponseDTO;
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

    public ClientResponseDTO create(Client client) {
        Client entity = repository.save(client);
        return new ClientResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getTelephone());
    }

    public List<Client> readAll() {
        return repository.findAll();
    }
}
