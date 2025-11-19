package com.seuprojeto.mopo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seuprojeto.mopo.dto.RevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.service.RevenueService;

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
@RequestMapping()
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
