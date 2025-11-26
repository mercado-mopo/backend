package com.seuprojeto.mopo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateRevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.repository.IRevenueRepository;

@Service
public class RevenueService {

  @Autowired
  private IRevenueRepository repository;

  public Revenue create(CreateOrUpdateRevenueRequestDTO dto) {
    var entity = new Revenue(
      dto.title(),
      dto.image(),
      dto.ingredients(),
      dto.instructions(),
      dto.preparationTimeInMinutes()
    );
    return repository.save(entity);
  }

  public List<Revenue> readAll() {
    return repository.findAll();
  }

  public Revenue readById(UUID id) {
    return repository.findById(id).orElse(null);
  }

  public Revenue update(UUID id, CreateOrUpdateRevenueRequestDTO dto) {
    return repository.findById(id).map(existing -> {
      existing.setTitle(dto.title());
      existing.setDescription(dto.description());
      existing.setPreparationTime(dto.preparationTimeInMinutes());
      existing.setEfficiency(dto.efficiency());

      return repository.save(existing);
    }).orElse(null);
  }

  public Revenue delete(UUID id) throws Exception {
    var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    repository.deleteById(id);
    return entity;
  }
}
