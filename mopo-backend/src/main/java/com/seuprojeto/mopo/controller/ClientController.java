package com.seuprojeto.mopo.controller;

import com.seuprojeto.mopo.dto.ClientResponseDTO;
import com.seuprojeto.mopo.model.Client;
import com.seuprojeto.mopo.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody Client client) {
        var dto = service.create(client);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<Client>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }
}
