package com.seuprojeto.mopo.controller;

import com.seuprojeto.mopo.dto.ClienteDTO;
import com.seuprojeto.mopo.model.Cliente;
import com.seuprojeto.mopo.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

  @Autowired
  private ClienteService service;

  @PostMapping
  public ResponseEntity<ClienteDTO> create(@RequestBody Cliente client) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(client));
  }

  @GetMapping
  public ResponseEntity<List<Cliente>> readAll() {
    return ResponseEntity.status(HttpStatus.OK).body(service.listar());
  }
}
