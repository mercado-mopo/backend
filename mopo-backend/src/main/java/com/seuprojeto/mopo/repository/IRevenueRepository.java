package com.seuprojeto.mopo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seuprojeto.mopo.model.Receita;

@Repository
public interface IRevenueRepository extends JpaRepository<Receita, Long> {
}
