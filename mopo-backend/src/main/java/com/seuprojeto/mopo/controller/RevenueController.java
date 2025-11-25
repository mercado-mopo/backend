package com.seuprojeto.mopo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seuprojeto.mopo.dto.ReceitaDTO;
import com.seuprojeto.mopo.model.Receita;
import com.seuprojeto.mopo.service.ReceitaService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/revenue")
public class RevenueController {
  @Autowired
  private ReceitaService service;

  @PostMapping
  public ResponseEntity<Receita> create(@RequestBody ReceitaDTO dto) {
    var entity = service.criarReceita(dto);
    return ResponseEntity.created(URI.create("" + entity.getId())).body(entity);
  }

  @GetMapping
  public List<Receita> readAll() {
    return service.listarTodasReceitas();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Receita> readById(@PathVariable Long id) {
    var entity = service.buscaPorIdReceita(id);
    if (entity == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(entity);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Receita> update(@PathVariable Long id, @Valid @RequestBody ReceitaDTO dto) {
    var entity = service.atualizarReceita(id, dto);
    if (entity == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(entity);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    boolean wasDeleted = service.excluirReceita(id);
    return wasDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
}
