package com.seuprojeto.mopo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seuprojeto.mopo.dto.RevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.repository.RevenueRepository;

@Service
public class RevenueService {

    private final RevenueRepository repository;

    public RevenueService(RevenueRepository repository) {
        this.repository = repository;
    }

    public Revenue create(RevenueRequestDTO dto) {
        Revenue entity = new Revenue(dto.name(), dto.describe(), dto.preparationTime(), dto.efficiency(), dto.createdAt());
        return repository.save(entity);
    }

    public List<Revenue> readAll() {
        return repository.findAll();
    }

    public Revenue readById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Revenue update(Long id, RevenueRequestDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setName(dto.name());
            existing.setDescribe(dto.describe());
            existing.setPreparationTime(dto.preparationTime());
            existing.setEfficiency(dto.efficiency());
            existing.setCreatedAt(dto.createdAt());

            return repository.save(existing);
        }).orElse(null);
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
