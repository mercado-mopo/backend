package com.seuprojeto.mopo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateRevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.service.RevenueService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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
  private RevenueService service;

  @PostMapping
  public ResponseEntity<Revenue> create(@RequestBody CreateOrUpdateRevenueRequestDTO dto) {
    var entity = service.create(dto);
    return ResponseEntity.created(URI.create("" + entity.getId())).body(entity);
  }

  @GetMapping
  public List<Revenue> readAll() {
    return service.readAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Revenue> readById(@PathVariable UUID id) {
    var entity = service.readById(id);
    if (entity == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(entity);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Revenue> update(@PathVariable UUID id, @Valid @RequestBody CreateOrUpdateRevenueRequestDTO dto) {
    var entity = service.update(id, dto);
    if (entity == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(entity);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    boolean wasDeleted = service.delete(id);
    return wasDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
}
