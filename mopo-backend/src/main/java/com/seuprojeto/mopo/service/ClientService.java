package com.seuprojeto.mopo.service;

import com.seuprojeto.mopo.dto.response.ClientResponseDTO;
import com.seuprojeto.mopo.model.Client;
import com.seuprojeto.mopo.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

  @Autowired
  private IClientRepository repository;

  public ClientResponseDTO create(Client client) {
    var entity = repository.save(client);
    return new ClientResponseDTO(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getTelephone());
  }

  public List<Client> readAll() {
    return repository.findAll();
  }
}
