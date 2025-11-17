package com.seuprojeto.mopo.service;

import com.seuprojeto.mopo.dto.ClienteDTO;
import com.seuprojeto.mopo.model.Cliente;
import com.seuprojeto.mopo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public ClienteDTO salvar(Cliente cliente) {
        Cliente salvo = repo.save(cliente);
        return new ClienteDTO(salvo.getId(), salvo.getNome(), salvo.getEmail(), salvo.getTelefone());
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }
}
