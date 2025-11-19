package com.seuprojeto.mopo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seuprojeto.mopo.model.Revenue;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {
    
}
