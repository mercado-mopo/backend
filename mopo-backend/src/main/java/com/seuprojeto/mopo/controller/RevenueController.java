package com.seuprojeto.mopo.controller;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateRevenueRequestDTO;
import com.seuprojeto.mopo.dto.response.RevenueResponseDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.seuprojeto.mopo.dto.request.RevenueRequestDTO;
import com.seuprojeto.mopo.service.RevenueService;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<RevenueResponseDTO> create(@RequestBody CreateOrUpdateRevenueRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public List<RevenueResponseDTO> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevenueResponseDTO> readById(@PathVariable UUID id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.readById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevenueResponseDTO> update(@PathVariable UUID id, @RequestBody RevenueRequestDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RevenueResponseDTO> delete(@PathVariable UUID id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }
}
