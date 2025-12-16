package com.seuprojeto.mopo.auth.services;

import com.seuprojeto.mopo.dto.request.CreateClientRequestDTO;
import com.seuprojeto.mopo.model.Client;
import com.seuprojeto.mopo.repository.IClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final IClientRepository repository;

    public UserDetails signUp(CreateClientRequestDTO dto) throws Exception {
        var entity = Client.builder()
                .username(dto.username())
                .email(dto.email())
                .password(dto.password())
                .build();

        var exist = repository.findByEmail(dto.email());
        if (exist.isPresent())
            throw new Exception(String.format("User with email %s already exists", dto.email()));

        var response = repository.save(entity);

        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        return user;
    }

}
