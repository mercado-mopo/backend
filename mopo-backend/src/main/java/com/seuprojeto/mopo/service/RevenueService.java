package com.seuprojeto.mopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seuprojeto.mopo.dto.RevenueDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.repository.IRevenueRepository;

@Service
public class RevenueService {

  @Autowired
  private IRevenueRepository repository;

  public Revenue create(RevenueDTO dto) {
    var entity = new Revenue(dto.title(), dto.description(), dto.preparationTime(), dto.efficiency(), dto.createAt());
    return repository.save(entity);
  }

  public List<Revenue> readAll() {
    return repository.findAll();
  }

  public Revenue readById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public Revenue update(Long id, RevenueDTO dto) {
    return repository.findById(id).map(existing -> {
      existing.setTitle(dto.title());
      existing.setDescription(dto.description());
      existing.setPreparationTime(dto.preparationTime());
      existing.setEfficiency(dto.efficiency());
      existing.setCreatedAt(dto.createAt());

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
