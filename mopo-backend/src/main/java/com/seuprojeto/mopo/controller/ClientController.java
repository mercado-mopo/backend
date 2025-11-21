package com.seuprojeto.mopo.controller;

import com.seuprojeto.mopo.dto.response.UserResponseDTO;
import com.seuprojeto.mopo.dto.request.CreateClientRequestDTO;
import com.seuprojeto.mopo.model.Client;
import com.seuprojeto.mopo.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody CreateClientRequestDTO dto) {
        var response = service.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Client>> readAll() {
        return ResponseEntity.ok(service.readAll());
    }
}
