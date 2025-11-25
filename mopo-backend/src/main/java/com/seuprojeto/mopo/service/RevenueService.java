package com.seuprojeto.mopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seuprojeto.mopo.dto.ReceitaDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.repository.IRevenueRepository;

@Service
public class RevenueService {

  @Autowired
  private IRevenueRepository repository;

  public Revenue create(ReceitaDTO dto) {
    var entity = new Revenue(dto.nome(), dto.descricao(), dto.tempoPreparo(), dto.rendimento(), dto.dataInsercao());
    return repository.save(entity);
  }

  public List<Revenue> readAll() {
    return repository.findAll();
  }

  public Revenue readById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public Revenue update(Long id, ReceitaDTO dto) {
    return repository.findById(id).map(existing -> {
      existing.setTitle(dto.nome());
      existing.setDescription(dto.descricao());
      existing.setPreparationTime(dto.tempoPreparo());
      existing.setEfficiency(dto.rendimento());
      existing.setCreatedAt(dto.dataInsercao());

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
