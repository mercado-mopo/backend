package com.seuprojeto.mopo.service;

import com.seuprojeto.mopo.dto.ClienteDTO;
import com.seuprojeto.mopo.model.Cliente;
import com.seuprojeto.mopo.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

  @Autowired
  private IClientRepository repository;

  public ClienteDTO create(Cliente client) {
    var entity = repository.save(client);
    return new ClienteDTO(entity.getId(), entity.getNome(), entity.getEmail(), entity.getTelefone());
  }

  public List<Cliente> readAll() {
    return repository.findAll();
  }
}
