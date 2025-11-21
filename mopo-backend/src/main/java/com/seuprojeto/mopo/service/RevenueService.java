package com.seuprojeto.mopo.service;

import java.util.List;
import java.util.UUID;

import com.seuprojeto.mopo.dto.response.RevenueResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateRevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.repository.RevenueRepository;

import static java.rmi.server.LogStream.log;

@Service
@Slf4j
public class RevenueService {

    private final RevenueRepository repository;

    public RevenueService(RevenueRepository repository) {
        this.repository = repository;
    }

    public RevenueResponseDTO create(CreateOrUpdateRevenueRequestDTO dto) {
        var entity = Revenue.builder().
                title(dto.title()).
                describe(dto.describe()).
                image(dto.image()).
                ingredients(dto.ingredients()).
                instructions(dto.instructions()).
                preparationTime(dto.preparationTime()).
                efficiency(dto.efficiency()).
                rating(dto.rating()).
                difficulty(dto.difficulty()).build();

        var response = repository.save(entity);

        return new RevenueResponseDTO(
                response.getId(),
                response.getTitle(),
                response.getDescribe(),
                response.getImage(),
                response.getIngredients(),
                response.getInstructions(),
                response.getPreparationTime(),
                response.getEfficiency(),
                response.getRating(),
                response.getDifficulty()
        );
    }

    public List<RevenueResponseDTO> readAll() {
        return repository.findAll().
                stream().map(r ->
                        new RevenueResponseDTO(
                                r.getId(),
                                r.getTitle(),
                                r.getDescribe(),
                                r.getImage(),
                                r.getIngredients(),
                                r.getInstructions(),
                                r.getPreparationTime(),
                                r.getEfficiency(),
                                r.getRating(),
                                r.getDifficulty()
                        )).toList();
    }

    public RevenueResponseDTO readById(UUID id) throws Exception {
        var entity = repository.findById(id);
        if (entity.isEmpty())
            throw new Exception(String.format("Entidade com id %s não existe", id));

        return new RevenueResponseDTO(
                entity.get().getId(),
                entity.get().getTitle(),
                entity.get().getDescribe(),
                entity.get().getImage(),
                entity.get().getIngredients(),
                entity.get().getInstructions(),
                entity.get().getPreparationTime(),
                entity.get().getEfficiency(),
                entity.get().getRating(),
                entity.get().getDifficulty()
        );
    }

    public RevenueResponseDTO update(UUID id, CreateOrUpdateRevenueRequestDTO dto) throws Exception {
        var entity = repository.findById(id);

        if (entity.isEmpty())
            throw new Exception(String.format("Entidade com id %s não existe", id));

        BeanUtils.copyProperties(dto, entity);
        repository.save(entity.get());

        log(String.format("Entidade atualizada %s", entity.get())).println("Aqui" + entity.get());

        return new RevenueResponseDTO(
                entity.get().getId(),
                entity.get().getTitle(),
                entity.get().getDescribe(),
                entity.get().getImage(),
                entity.get().getIngredients(),
                entity.get().getInstructions(),
                entity.get().getPreparationTime(),
                entity.get().getEfficiency(),
                entity.get().getRating(),
                entity.get().getDifficulty()
        );
    }

    public void delete(UUID id) {
        if (repository.existsById(id))
            repository.deleteById(id);
    }
}
