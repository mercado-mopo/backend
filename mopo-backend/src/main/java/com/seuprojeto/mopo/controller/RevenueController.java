package com.seuprojeto.mopo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.seuprojeto.mopo.dto.response.RevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.service.RevenueService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/revenue")
public class RevenueController {
    private final RevenueService service;

    public RevenueController(RevenueService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Revenue> create(@RequestBody RevenueRequestDTO dto) {
        Revenue response = service.create(dto);
        return ResponseEntity.created(URI.create("" + response.getId())).body(response);
    }

    @GetMapping
    public List<Revenue> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revenue> readById(@PathVariable Long id) {
        var response = service.readById(id);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Revenue> update(@PathVariable Long id, @Valid @RequestBody RevenueRequestDTO dto) {
        Revenue response = service.update(id, dto);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean response = service.delete(id);
        return response ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
