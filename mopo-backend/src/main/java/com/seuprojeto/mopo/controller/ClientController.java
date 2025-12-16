package com.seuprojeto.mopo.controller;

import com.seuprojeto.mopo.dto.response.ClientResponseDTO;
import com.seuprojeto.mopo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> readAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.readAll());
    }
}
