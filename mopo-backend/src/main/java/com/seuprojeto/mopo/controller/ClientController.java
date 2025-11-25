package com.seuprojeto.mopo.controller;

import com.seuprojeto.mopo.dto.ClienteDTO;
import com.seuprojeto.mopo.model.Client;
import com.seuprojeto.mopo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

  @Autowired
  private ClientService service;

  @PostMapping
  public ResponseEntity<ClienteDTO> create(@RequestBody Client client) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(client));
  }

  @GetMapping
  public ResponseEntity<List<Client>> readAll() {
    return ResponseEntity.status(HttpStatus.OK).body(service.readAll());
  }
}
