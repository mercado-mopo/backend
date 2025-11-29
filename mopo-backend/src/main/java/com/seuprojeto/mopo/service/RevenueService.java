package com.seuprojeto.mopo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
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

  public Revenue readById(UUID id) throws Exception {
    return repository.findById(id).orElseThrow(()-> new Exception("Revenue not found"));
  }

  public Revenue update(UUID id, CreateOrUpdateRevenueRequestDTO dto) throws Exception {
    var entity = repository.findById(id).orElseThrow(() -> new Exception("Revenue not found"));
    BeanUtils.copyProperties(dto, entity);
    return repository.save(entity);
  }

  public Revenue delete(UUID id) throws Exception {
    var entity = repository.findById(id).orElseThrow(() -> new Exception("Revenue not found"));
    repository.deleteById(id);
    return entity;
  }
}
