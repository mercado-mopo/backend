package com.seuprojeto.mopo.controller;

import com.seuprojeto.mopo.auth.services.AuthenticationService;
import com.seuprojeto.mopo.dto.request.CreateClientRequestDTO;
import com.seuprojeto.mopo.dto.request.LoginUserRequestDTO;
import com.seuprojeto.mopo.dto.response.LoginResponseDTO;
import com.seuprojeto.mopo.dto.response.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService service;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody CreateClientRequestDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(dto));
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDTO> signIn(@RequestBody LoginUserRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.login(dto));
    }
}
