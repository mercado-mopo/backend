package com.seuprojeto.mopo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateRevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.service.RevenueService;

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
    return ResponseEntity.status(HttpStatus.CREATED).body(entity);
  }

  @GetMapping
  public List<Revenue> readAll() {
    return service.readAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Revenue> readById(@PathVariable UUID id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.readById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Revenue> update(@PathVariable UUID id, @RequestBody CreateOrUpdateRevenueRequestDTO dto) {
    return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Revenue> delete(@PathVariable UUID id) throws Exception {
    return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
  }
}
