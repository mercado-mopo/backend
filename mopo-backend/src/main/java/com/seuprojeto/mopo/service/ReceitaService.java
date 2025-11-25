package com.seuprojeto.mopo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seuprojeto.mopo.dto.ReceitaDTO;
import com.seuprojeto.mopo.model.Receita;
import com.seuprojeto.mopo.repository.ReceitaRepository;

@Service
public class ReceitaService {
  private final ReceitaRepository repository;

  public ReceitaService(ReceitaRepository repository) {
    this.repository = repository;
  }

  public Receita criarReceita(ReceitaDTO dto) {
    Receita receita = new Receita(dto.nome(), dto.descricao(), dto.tempoPreparo(), dto.rendimento(), dto.dataInsercao());
    return repository.save(receita);
  }

  public List<Receita> listarTodasReceitas() {
    return repository.findAll();
  }

  public Receita buscaPorIdReceita(Long id) {
    return repository.findById(id).orElse(null);
  }

  public Receita atualizarReceita(Long id, ReceitaDTO dto) {
    return repository.findById(id).map(existing -> {
      existing.setNome(dto.nome());
      existing.setDescricao(dto.descricao());
      existing.setTempoPreparo(dto.tempoPreparo());
      existing.setRendimento(dto.rendimento());
      existing.setDataInsercao(dto.dataInsercao());

      return repository.save(existing);
    }).orElse(null);
  }

  public boolean excluirReceita(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
