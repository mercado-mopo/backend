package com.seuprojeto.mopo.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateRevenueRequestDTO;
import com.seuprojeto.mopo.dto.response.RevenueResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seuprojeto.mopo.dto.request.RevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.repository.IRevenueRepository;

@Service
@Slf4j
public class RevenueService {
    @Autowired
    private IRevenueRepository repository;

    public RevenueResponseDTO create(CreateOrUpdateRevenueRequestDTO dto) {
        var entity = Revenue.builder()
                .title(dto.title())
                .describe(dto.describe())
                .image(dto.image())
                .ingredients(dto.ingredients())
                .instructions(dto.instructions())
                .preparationTime(dto.preparationTime())
                .efficiency(dto.efficiency())
                .rating(dto.rating())
                .difficulty(dto.difficulty())
                .build();

        var response = repository.save(entity);

        return new RevenueResponseDTO(response);
    }

    public List<RevenueResponseDTO> readAll() {
        return repository.findAll().stream().map(RevenueResponseDTO::new).collect(Collectors.toList());
    }

    public RevenueResponseDTO readById(UUID id) throws Exception {
        var entity = repository.findById(id);

        if (entity.isEmpty())
            throw new Exception(String.format("Revenue with id %s not found", id));

        return new RevenueResponseDTO(entity.get());
    }

    public RevenueResponseDTO update(UUID id, RevenueRequestDTO dto) throws Exception {
        var entity = repository.findById(id);
        if (entity.isEmpty())
            throw new Exception(String.format("Revenue with id %s not found", id));

        BeanUtils.copyProperties(dto, entity);

        var response = repository.save(entity.get());

        return new RevenueResponseDTO(response);
    }

    public RevenueResponseDTO delete(UUID id) throws Exception {
        var entity = readById(id);

        repository.deleteById(entity.id());
        return entity;
    }
}
