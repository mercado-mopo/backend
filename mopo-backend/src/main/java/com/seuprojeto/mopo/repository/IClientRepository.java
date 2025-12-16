package com.seuprojeto.mopo.repository;

import com.seuprojeto.mopo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByEmail(String email);
    boolean existsByEmail(String email);
}
