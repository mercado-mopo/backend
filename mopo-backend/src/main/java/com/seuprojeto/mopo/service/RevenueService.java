package com.seuprojeto.mopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seuprojeto.mopo.dto.ReceitaDTO;
import com.seuprojeto.mopo.model.Receita;
import com.seuprojeto.mopo.repository.ReceitaRepository;

@Service
public class RevenueService {

  @Autowired
  private ReceitaRepository repository;

  public Receita create(ReceitaDTO dto) {
    var entity = new Receita(dto.nome(), dto.descricao(), dto.tempoPreparo(), dto.rendimento(), dto.dataInsercao());
    return repository.save(entity);
  }

  public List<Receita> readAll() {
    return repository.findAll();
  }

  public Receita readById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public Receita update(Long id, ReceitaDTO dto) {
    return repository.findById(id).map(existing -> {
      existing.setNome(dto.nome());
      existing.setDescricao(dto.descricao());
      existing.setTempoPreparo(dto.tempoPreparo());
      existing.setRendimento(dto.rendimento());
      existing.setDataInsercao(dto.dataInsercao());

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
