package com.seuprojeto.mopo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seuprojeto.mopo.dto.ReceitaDTO;
import com.seuprojeto.mopo.model.Receita;
import com.seuprojeto.mopo.service.ReceitaService;

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
@RequestMapping("/api/revenue")
public class ReceitaController {
    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Receita> criarReceita(@Valid @RequestBody ReceitaDTO dto){
        Receita criado = service.criarReceita(dto);
        return ResponseEntity.created(URI.create("" + criado.getId())).body(criado);
    }

    @GetMapping
    public List<Receita> listarTodasReceitas(){
        return service.listarTodasReceitas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> buscarPorIdReceita(@PathVariable Long id){
        Receita receita = service.buscaPorIdReceita(id);
        if (receita == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(receita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizarReceita(@PathVariable Long id, @Valid @RequestBody ReceitaDTO dto){
        Receita atualizado = service.atualizarReceita(id, dto);
        if (atualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirReceita(@PathVariable Long id){
        boolean deletado = service.excluirReceita(id);
        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
