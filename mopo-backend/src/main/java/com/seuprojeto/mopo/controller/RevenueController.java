package com.seuprojeto.mopo.controller;

import com.seuprojeto.mopo.dto.response.RevenueResponseDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateRevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.service.RevenueService;

import jakarta.validation.Valid;

import java.net.URI;
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
        var response = service.create(dto);
        if (response == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<RevenueResponseDTO> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevenueResponseDTO> readById(@PathVariable UUID id) throws Exception {
        var response = service.readById(id);
        if (response == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevenueResponseDTO> update(@PathVariable UUID id, @RequestBody CreateOrUpdateRevenueRequestDTO dto) throws Exception {
        var response = service.update(id, dto);
        if (response == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
