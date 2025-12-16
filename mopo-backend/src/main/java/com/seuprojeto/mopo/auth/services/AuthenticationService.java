package com.seuprojeto.mopo.auth.services;

import com.seuprojeto.mopo.dto.request.CreateClientRequestDTO;
import com.seuprojeto.mopo.dto.request.LoginUserRequestDTO;
import com.seuprojeto.mopo.dto.response.LoginResponseDTO;
import com.seuprojeto.mopo.dto.response.UserResponseDTO;
import com.seuprojeto.mopo.model.Client;
import com.seuprojeto.mopo.model.shared.RoleName;
import com.seuprojeto.mopo.repository.IClientRepository;
import com.seuprojeto.mopo.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IRoleRepository roleRepository;
    private final IClientRepository clientRepository;
    private final CustomUserDetailsService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserResponseDTO register(CreateClientRequestDTO dto) {
        if (clientRepository.existsByEmail(dto.email())) {
            throw new UsernameNotFoundException("Email Already Exists");
        }

        var entity = Client.builder()
                .username(dto.username())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .telephone(dto.telephone())
                .cpf(dto.cpf())
                .dateOfBirth(dto.birthday())
                .roles(new HashSet<>())
                .build();

        var defaultRole = roleRepository.findByRoleName(RoleName.ROLE_CLIENT)
                .orElseThrow(() -> new RuntimeException("Role Not Found"));

        entity.getRoles().add(defaultRole);

        var response = clientRepository.save(entity);
        return new UserResponseDTO(response);
    }

    public LoginResponseDTO login(LoginUserRequestDTO dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.password()));
        var user = userService.loadUserByUsername(dto.email());

        return new LoginResponseDTO(jwtService.generateToken(user), jwtService.getExpiration());
    }
}
